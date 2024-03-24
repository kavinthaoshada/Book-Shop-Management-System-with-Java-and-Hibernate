<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String sid = request.getParameter("sid");
    String item_name = request.getParameter("item_name");
    String unitprice = request.getParameter("unitprice");
    String inputQty = request.getParameter("inputQty");
    String price = request.getParameter("price");
    String image = request.getParameter("image");

    if (sid != null && !sid.isEmpty()) {
%>
<%--<?php--%>
<%--if(isset($_GET)){--%>
<%--?>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" href="assets/resources/infinity_logo2.svg" />
    <title>Payment Integration (Stripe)</title>
    <link rel="stylesheet" href="assets/css/_style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<button type="button" onclick="goback()" class="back">Go Back</button>
<div class="row">
    <div class="col-md-6">
        <div class="form-container">
<%--            <?php--%>
<%--                    echo $_GET["unitprice"];--%>
<%--                    echo $_GET["inputQty"];--%>
<%--                    echo $_GET["sid"];--%>
<%--                    ?>--%>
            <form id="payment-form" action="createPayment" method="GET">
                <div>
                    <input type="text" id="c_name" name="c_name" required>
                    <lable>Customer Name</lable>
                </div>
                <div>
                    <input type="text" id="address" name="address" required>
                    <lable>Address</lable>
                </div>
                <div>
                    <input type="number" id="ph" name="phone" pattern="\d{10}" maxlength="10" required>
                    <lable>Contact Number</lable>
                </div>
                <div>
                    <input type="text" name="product_name" value="<%= item_name %>" disabled required>
                    <lable>Product Name</lable>
                </div>
                <div>
                    <input type="text" name="price" value="<%= price %>" disabled required>
                    <lable>Price</lable>
                </div>

                <input type="hidden" id="amount" name="amount" value="<%= price %>">
                <input type="hidden" id="product_name" name="product_name" value="<%= item_name %>">

                <input type="hidden" id="unitprice" name="unitprice" value="<%= unitprice %>">
                <input type="hidden" id="inputQty" name="inputQty" value="<%= inputQty %>">
                <input type="hidden" id="sid" name="sid" value="<%= sid %>">

                <script
                        src ="https://checkout.stripe.com/checkout.js" class = "stripe-button"
                        data-key = "pk_test_51LauixIjAOH1QSloFfHFOFUN8xQ3Bc1XuB3ouIeZVK0dwXAnJZ3qpsnI7dDvsKufxmdhS0H7Y4SEM4sfpMASzh8x009HAJpvuC"
                        data-amount = "<%= Integer.parseInt(price.replace(",", "")) * 100 %>"
                data-name = "<%= item_name %>"
                data-description = "<%= item_name %>"
                data-image = "<%= image %>"
                data-currency = "lkr"
                data-locale = "auto">
                </script>

<%--                <button type="button" onclick="initiateStripeCheckout()">Pay <%= price %> LKR</button>--%>
<%--                <button type="button" onclick="initiateStripePayment()">Pay <%= price %> LKR</button>--%>
            </form>
        </div>
    </div>

    <div class="col-md-6">
        <div class="checkout-container">
            <h4>Product Name &nbsp;:&nbsp;<%= item_name %></h4>
            <img src="<%= image %>" />
            <span>Price &nbsp;:&nbsp;<%= price %></span>
        </div>
    </div>

</div>
<%
        }
%>

<script>
    function goback(){
        window.history.go(-1);
    }

    $('#ph').on('keypress',function(){
        var text = $(this).val().length;
        if(text > 10){
            return false;
        }else{
            $('#ph').text($(this).val());
        }
    });
</script>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>--%>
<%--<script src="https://js.stripe.com/v3/"></script>--%>
<%--<script>--%>
<%--    function testFunction(){--%>
<%--        alert("im in..");--%>
<%--    }--%>
<%--    var stripe = Stripe('pk_test_51LauixIjAOH1QSloFfHFOFUN8xQ3Bc1XuB3ouIeZVK0dwXAnJZ3qpsnI7dDvsKufxmdhS0H7Y4SEM4sfpMASzh8x009HAJpvuC');--%>
<%--    var elements = stripe.elements();--%>
<%--    var card = elements.create('card');--%>
<%--    card.mount('#card-element');--%>

<%--    document.addEventListener('DOMContentLoaded', function() {--%>
<%--    var form = document.getElementById('payment-form');--%>
<%--    form.addEventListener('submit', function(event) {--%>
<%--        console.log('Form submit event triggered');--%>
<%--        alert("im in");--%>
<%--        event.preventDefault();--%>

<%--        var priceInput = document.getElementById('price').value;--%>
<%--        var priceInCents = parseInt(priceInput.replace(',', '')) * 100;--%>

<%--        stripe.createToken(card, { amount: priceInCents }).then(function(result) {--%>
<%--            alert("im in2");--%>
<%--            if (result.error) {--%>
<%--                // var errorElement = document.getElementById('card-errors');--%>
<%--                // errorElement.textContent = result.error.message;--%>
<%--                alert("card-errors");--%>
<%--            } else {--%>
<%--                stripeTokenHandler(result.token, priceInCents);--%>
<%--            }--%>
<%--        });--%>
<%--    });--%>
<%--    });--%>

<%--    function stripeTokenHandler(token, amount) {--%>
<%--        var inputQty = document.getElementById("inputQty").value;--%>
<%--        var sid = document.getElementById("sid").value;--%>
<%--        var c_name = document.getElementById("c_name").value;--%>
<%--        var address = document.getElementById("address").value;--%>
<%--        let tokenObject = {--%>
<%--            "token": token,--%>
<%--            "amount": amount,--%>
<%--            "inputQty": inputQty,--%>
<%--            "sid": sid,--%>
<%--            "c_name": c_name,--%>
<%--            "address": address,--%>
<%--        };--%>
<%--        var xhr = new XMLHttpRequest();--%>
<%--        xhr.open('POST', 'charge', true);--%>
<%--        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');--%>
<%--        xhr.onreadystatechange = function () {--%>
<%--            if (xhr.readyState === XMLHttpRequest.DONE) {--%>
<%--                if (xhr.status == 200 && xhr.status == 201) {--%>
<%--                    alert('Payment successful! ' + xhr.responseText);--%>
<%--                } else {--%>
<%--                    alert('Payment failed. ' + xhr.responseText);--%>
<%--                }--%>
<%--            }--%>
<%--        };--%>
<%--        xhr.send(JSON.stringify(tokenObject));--%>
<%--    }--%>


<%--</script>--%>



</body>
</html>




