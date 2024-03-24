package com.calm.webdb.service;

import com.calm.webdb.entity.*;
import com.calm.webdb.util.HibernateUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

public class PaymentGatewayService {
    public String createPayment(int amount, int inputQty, int sid, String c_name, String address, String userEmail) throws ParseException {

        String orderId = AdminService.generateUniqueId();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<StockEntity> query = session.createQuery("SELECT e FROM StockEntity e WHERE e.id = :stockId", StockEntity.class)
                .setParameter("stockId", sid);
        StockEntity prodauctData = query.uniqueResult();

        double uprice = prodauctData.getSellingPrice();
        double total = uprice * inputQty;

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Asia/Colombo");
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = zonedDateTime.format(formatter);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate;
        utilDate = dateFormat.parse(formattedDateTime);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        int invoiceId = 0;
        if(!userEmail.equals("empty")){
            InvoiceEntity insertInvoice = new InvoiceEntity();
            insertInvoice.setOrderId(orderId);
            insertInvoice.setUsersEmail(userEmail);
            insertInvoice.setDate(sqlDate);
            insertInvoice.setEmployeeEmpEmail("none");
            insertInvoice.setStatus(0);
            invoiceId = (int) session.save(insertInvoice);
        }else{
            InvoiceEntity insertInvoice = new InvoiceEntity();
            insertInvoice.setOrderId(orderId);
            insertInvoice.setUsersEmail("none");
            insertInvoice.setDate(sqlDate);
            insertInvoice.setEmployeeEmpEmail("none");
            insertInvoice.setStatus(0);
            invoiceId = (int) session.save(insertInvoice);
        }

        int updatedStockQty = prodauctData.getQty() - inputQty;
        StockEntity existStock = session.get(StockEntity.class, prodauctData.getId());
            existStock.setQty(updatedStockQty);
            session.update(existStock);

        InvoiceItemEntity insertInvoiceItem = new InvoiceItemEntity();
        insertInvoiceItem.setQty(inputQty);
        insertInvoiceItem.setInvoiceId(invoiceId);
        insertInvoiceItem.setStockId(prodauctData.getId());
        session.save(insertInvoiceItem);

        InvoicePaymentEntity insertInvoicePayment = new InvoicePaymentEntity();
        insertInvoicePayment.setPayment(total);
        insertInvoicePayment.setBalance(0.0);
        insertInvoicePayment.setInvoiceId(invoiceId);
        insertInvoicePayment.setPaymentTypeId(1);
        session.save(insertInvoicePayment);

        transaction.commit();
        session.close();

        return orderId;
    }

    public void invoiceStatusUpdate(int invoiceId){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session hibernateSession = sessionFactory.openSession();
        Transaction transaction = hibernateSession.beginTransaction();
        try {
            Query<InvoiceEntity> invoiceEntityQuery = hibernateSession.createQuery("SELECT i FROM InvoiceEntity i " +
                            "WHERE i.id= :invoiceId", InvoiceEntity.class)
                    .setParameter("invoiceId", invoiceId);
            InvoiceEntity invoice = invoiceEntityQuery.uniqueResult();
            int newStatus = 0;
            if (invoice.getStatus()==0) {
                InvoiceEntity updateInvoiceStatus = hibernateSession.get(InvoiceEntity.class, invoiceId);
                updateInvoiceStatus.setStatus(1);
                hibernateSession.update(updateInvoiceStatus);
                newStatus = 1;
            }else if(invoice.getStatus()==1){
                InvoiceEntity updateInvoiceStatus = hibernateSession.get(InvoiceEntity.class, invoiceId);
                updateInvoiceStatus.setStatus(2);
                hibernateSession.update(updateInvoiceStatus);
                newStatus = 2;
            }else if(invoice.getStatus()==2){
                InvoiceEntity updateInvoiceStatus = hibernateSession.get(InvoiceEntity.class, invoiceId);
                updateInvoiceStatus.setStatus(3);
                hibernateSession.update(updateInvoiceStatus);
                newStatus = 3;
            }else if(invoice.getStatus()==3){
                InvoiceEntity updateInvoiceStatus = hibernateSession.get(InvoiceEntity.class, invoiceId);
                updateInvoiceStatus.setStatus(4);
                hibernateSession.update(updateInvoiceStatus);
                newStatus = 4;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            transaction.commit();
            hibernateSession.close();
        }
    }


}
