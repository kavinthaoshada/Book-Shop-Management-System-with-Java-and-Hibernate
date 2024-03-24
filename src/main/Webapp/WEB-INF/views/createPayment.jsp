<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*, java.util.*" %>
<%
    // Retrieving the data from the POST request
    String token = request.getParameter("stripeToken");
    String contactName = request.getParameter("c_name");
    String tokenCardType = request.getParameter("stripeTokenType");
    String phone = request.getParameter("phone");
    String email = request.getParameter("stripeEmail");
    String address = request.getParameter("address");
    String amount = request.getParameter("amount");
    String desc = request.getParameter("product_name");

    System.out.println("hi m");
    System.out.println("address : "+address);
    System.out.println("token : "+token);

    String unitprice = request.getParameter("unitprice");
    String inputQty = request.getParameter("inputQty");
    String sid = request.getParameter("sid");
    String price = request.getParameter("price");

    // You can now use these variables to process the data as needed
    // For example, you can store them in a database, perform further processing, etc.
%>
<!DOCTYPE html>
<html>
<head>
    <title>Infinity | Checkout charge</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
</head>
<body>
<input type="hidden" id="amount" name="amount" value="<%= amount %>">
<input type="hidden" id="product_name" name="product_name" value="<%= desc %>">

<input type="hidden" id="unitprice" name="unitprice" value="<%= unitprice %>">
<input type="hidden" id="inputQty" name="inputQty" value="<%= inputQty %>">
<input type="hidden" id="sid" name="sid" value="<%= sid %>">
<input type="hidden" id="c_name" name="c_name" value="<%= contactName %>">
<input type="hidden" id="address" name="address" value="<%= address %>">
<input type="hidden" id="price" name="price" value="<%= price %>">
<input type="hidden" id="token" name="token" value="<%= token %>">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://js.stripe.com/v3/"></script>
<script>
    tokenCreater();
    function testFunction(){
        alert("im in..");
    }
    // var stripe = Stripe('pk_test_51LauixIjAOH1QSloFfHFOFUN8xQ3Bc1XuB3ouIeZVK0dwXAnJZ3qpsnI7dDvsKufxmdhS0H7Y4SEM4sfpMASzh8x009HAJpvuC');
    // var elements = stripe.elements();
    // var card = elements.create('card');
    // card.mount('#card-element');

    function tokenCreater(){
        console.log('Form submit event triggered');
        alert("im in token create");

        var amount = document.getElementById('amount').value;

        var token1 = document.getElementById("token").value;
        stripeTokenHandler(token1, amount);

    }

    function stripeTokenHandler(token, amount) {
        var inputQty = document.getElementById("inputQty").value;
        var sid = document.getElementById("sid").value;
        var c_name = document.getElementById("c_name").value;
        var address = document.getElementById("address").value;
        let tokenObject = {
            "token": token,
            "amount": amount,
            "inputQty": inputQty,
            "sid": sid,
            "c_name": c_name,
            "address": address,
        };
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'charge', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status == 200 || xhr.status == 201) {
                    alert('Payment successful! ' + xhr.responseText);
                    let text = xhr.responseText;
                    const myArray = text.split(" ");
                        // alert("show invoice 1");
                        fetch("invoice?order_id="+myArray[0]+"&cname="+myArray[2]+"&add="+myArray[3]+"&el="+myArray[1], {
                            method: "GET"
                        }).then(response => response.text())
                            .then(data => {
                                document.open();
                                document.write(data);
                                document.close();
                            });
                } else {
                    alert('Payment failed. ' + xhr.responseText);
                }
            }
        };
        xhr.send(JSON.stringify(tokenObject));
    }


</script>
</body>
</html>
