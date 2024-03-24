package com.calm.webdb.service;

import com.calm.webdb.entity.*;
import com.calm.webdb.util.HibernateUtil;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GRNService {

    public void createGrn(String empEmail, int tlength, int vendor, int ptype, double payment, double balance, JsonNode items) throws ParseException {
        System.out.println("in user update1");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            LocalDateTime localDateTime = LocalDateTime.now();
            ZoneId zoneId = ZoneId.of("Asia/Colombo");
            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDateTime = zonedDateTime.format(formatter);

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate;
            utilDate = dateFormat.parse(formattedDateTime);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            GrnEntity insertGrn = new GrnEntity();
            insertGrn.setDateTime(sqlDate);
            insertGrn.setVendorId(vendor);
            insertGrn.setEmployeeEmpEmail(empEmail);
            int grnId = (int) session.save(insertGrn);
//            transaction.commit();

            JsonNode itemsNode = items;
            for (JsonNode itemNode : itemsNode) {
                int bookID = itemNode.get("bookID").asInt();
                int quantity = itemNode.get("quantity").asInt();
                double dwc = itemNode.get("dwc").asDouble();
                double doc = itemNode.get("doc").asDouble();
                double bprice = itemNode.get("bprice").asDouble();
                double sprice = itemNode.get("sprice").asDouble();

                Query<StockEntity> query1 = session.createQuery("SELECT s FROM StockEntity s WHERE s.bookId = :bookID", StockEntity.class)
                        .setParameter("bookID", bookID);
                List<StockEntity> stocks = query1.getResultList();
//                transaction.commit();
                boolean isStockExist = false;
                int existStockId = 0;
                int existStockQty = 0;
                for(StockEntity stock : stocks){
                    isStockExist = true;
                    existStockId = stock.getId();
                    existStockQty = stock.getQty();
                }
                StockEntity existStock = session.get(StockEntity.class, existStockId);
                if(isStockExist){
                    existStockQty = existStockQty + quantity;
                    existStock.setQty(existStockQty);
                    session.update(existStock);
//                    transaction.commit();
                }else{
                    StockEntity insertStock = new StockEntity();
                    insertStock.setQty(quantity);
                    insertStock.setSellingPrice(sprice);
                    insertStock.setBookId(bookID);
                    insertStock.setDeliveryFeeColombo(dwc);
                    insertStock.setDeliveryFeeOther(doc);
                    existStockId = (int) session.save(insertStock);
//                    transaction.commit();
                }

                GrnItemEntity insertGrnItem = new GrnItemEntity();
                insertGrnItem.setQty(quantity);
                insertGrnItem.setBuyingPrice(bprice);
                insertGrnItem.setGrnId(grnId);
                insertGrnItem.setStockId(existStockId);
                session.save(insertGrnItem);
//                transaction.commit();

                //System.out.println("Item: BookID=" + bookID + ", Quantity=" + quantity + ", DWC=" + dwc + ", DOC=" + doc + ", BPrice=" + bprice + ", SPrice=" + sprice);
            }

            GrnPaymentEntity insertGrnPayment = new GrnPaymentEntity();
            insertGrnPayment.setPayment(payment);
            insertGrnPayment.setBalance(balance);
            insertGrnPayment.setPaymentTypeId(ptype);
            insertGrnPayment.setGrnId(grnId);
            session.save(insertGrnPayment);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            session.close();
        }
    }

}
