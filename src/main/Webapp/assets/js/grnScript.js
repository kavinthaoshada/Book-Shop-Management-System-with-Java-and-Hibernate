function addtogrn() {

    var bid = document.getElementById("bookID").innerHTML;
    var bName = document.getElementById("bookName").innerHTML;
    var vendor = document.getElementById("vendor").value;
    var qty = document.getElementById("qty").value;
    var dwc = document.getElementById("dwc").value;
    var doc = document.getElementById("doc").value;
    var buyingPrice = document.getElementById("bprice").value;
    var sellingPrice = document.getElementById("sprice").value;
    // alert(buyingPrice);

    if (bid == "None") {
        alert("Please select Book");
    } else if (bName == "None") {
        alert("Please select Book");
    } else if (vendor == 0) {
        alert("Please select vendor");
    } else if (qty <= 0) {
        alert("quantity cannot be lower than or equal to 0.");
    } else if (buyingPrice.length === 0) {
        alert("Buying price is empty");
    } else if (dwc.length === 0) {
        alert("Delivery fee of colombo is empty");
    } else if (doc.length === 0) {
        alert("Delivery fee of other is empty");
    } else if (sellingPrice.length === 0) {
        alert("Selling price is empty");
    } else {


        var tlength = document.getElementById("grntable").rows.length;

        var isfound = false;
        var row;
        for (var n = 1; n < tlength; n++) {

            if (bid.toString() === (document.getElementById("grntable").rows[n].cells[0].innerHTML).toString() && sellingPrice.toString() === (document.getElementById("grntable").rows[n].cells[4].innerHTML).toString()) {

                isfound = true;
                row = n;
                alert("this book already added..");
                break;
            }
        }

        if (isfound) {
            document.getElementById("grntable").rows[row].cells[2].innerHTML = parseInt(document.getElementById("grntable").rows[row].cells[2].innerHTML) + parseInt(qty);
            document.getElementById("grntable").rows[row].cells[5].innerHTML = buyingPrice * parseInt(document.getElementById("grntable").rows[row].cells[2].innerHTML);

        } else {
            var tr = document.getElementById('grntable').insertRow(1);

            var y1 = tr.insertCell(0);
            var y2 = tr.insertCell(1);
            var y3 = tr.insertCell(2);
            var y4 = tr.insertCell(3);
            var y5 = tr.insertCell(4);
            var y6 = tr.insertCell(5);
            var y7 = tr.insertCell(6);
            var y8 = tr.insertCell(7);
            y1.innerHTML = bid;
            y2.innerHTML = bName;
            y3.innerHTML = qty;
            y4.innerHTML = dwc;
            y5.innerHTML = doc;
            y6.innerHTML = buyingPrice;
            y7.innerHTML = sellingPrice;
            y8.innerHTML = buyingPrice * qty;

        }

        isfound = false;
        document.getElementById("bookID").innerHTML = "None";
        document.getElementById("bookName").innerHTML = "None";
        document.getElementById("qty").value = 0;
        document.getElementById("dwc").value = "";
        document.getElementById("doc").value = "";
        document.getElementById("bprice").value = "";
        document.getElementById("sprice").value = "";

        totalCal();

    }



}

function totalCal() {

    var tlength = document.getElementById("grntable").rows.length;
    var stotal = 0;
    for (var i = 1; i <= tlength; i++) {
        stotal = stotal + parseInt(document.getElementById("grntable").rows[i].cells[7].innerHTML);
        document.getElementById("subtotal").innerHTML = stotal;
    }


}

function balanceCal() {

    var subtotal = document.getElementById("subtotal").innerHTML;
    var payment = document.getElementById("payment").value;

    document.getElementById("balance").value = parseInt(subtotal) - parseInt(payment);

}

function creategrn() {

    var tlength = (document.getElementById("grntable").rows.length) - 1;
    var ptype = document.getElementById("ptype").value;
    var vendor = document.getElementById("vendor").value;
    var payment = document.getElementById("payment").value;
    var balance = document.getElementById("balance").value;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "createGRNProcess");
    xhr.setRequestHeader("Content-Type", "application/json");

    var items = [];
    for (var i = 1; i <= tlength; i++) {
        var item = {
            "bookID": document.getElementById("grntable").rows[i].cells[0].innerHTML,
            "quantity": document.getElementById("grntable").rows[i].cells[2].innerHTML,
            "dwc": document.getElementById("grntable").rows[i].cells[3].innerHTML,
            "doc": document.getElementById("grntable").rows[i].cells[4].innerHTML,
            "bprice": document.getElementById("grntable").rows[i].cells[5].innerHTML,
            "sprice": document.getElementById("grntable").rows[i].cells[6].innerHTML
        };
        items.push(item);
    }

    // JSON data
    let grn = {
        "tlength": tlength,
        "vendor": vendor,
        "ptype": ptype,
        "payment": payment,
        "balance": balance,
        "items": items
    };

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) { // Request is complete
            if (xhr.status === 200 || xhr.status === 201) {
                alert("Success");
                window.location.reload();
                console.log("Response: " + xhr.statusText);
                console.log("Response: " + xhr.responseText);
            } else {
                alert("Request failed: " + xhr.statusText);
                console.log("Request failed: " + xhr.statusText);
            }
        }
    };

    xhr.send(JSON.stringify(grn));
}