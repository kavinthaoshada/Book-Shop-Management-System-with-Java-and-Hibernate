function home() {

    // window.location = "index.php";
    fetch("home", {
        method: "GET"
    }).then(response => response.text())
        .then(data => {
            document.open();
            document.write(data);
            document.close();
    });
}

var bm1;

function signInModal() {

    if (bm2 != null) {
        bm2.hide();
    }
    var m1 = document.getElementById("signInModal");
    bm1 = new bootstrap.Modal(m1);
    bm1.show();

}

var bm2;

function signUpModal() {

    if (bm1 != null) {
        bm1.hide();
    }

    var m2 = document.getElementById("signUpModal");
    bm2 = new bootstrap.Modal(m2);
    bm2.show();


}

var ven;

function vendorModal() {

    var v = document.getElementById("vendorModal");
    ven = new bootstrap.Modal(v);
    ven.show();


}
function formatDateToYYYYMMDD(date) {
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');

    return `${year}-${month}-${day}`;
}
function signUp() {

    let f = document.getElementById("fname").value;
    let l = document.getElementById("lname").value;
    let e = document.getElementById("email").value;
    let p = document.getElementById("password").value;
    let m = document.getElementById("mobile").value;
    let g = document.getElementById("gender").value;
    // Current date
    const currentDate = new Date();
    // "YYYY-MM-DD" format
    const formattedDate = formatDateToYYYYMMDD(currentDate);
    let joinDate = formattedDate;

    if(f == ""){
        alert("First Name cannot be Empty");
    }else if(l == ""){
        alert("Last Name cannot be Empty");
    }else if(e == ""){
        alert("Email cannot be Empty");
    }else if(!ValidateEmail(e)){
        // alert("Email cannot be Empty");
    }else if(p == ""){
        alert("Password cannot be Empty");
    }else if(m == ""){
        alert("Mobile cannot be Empty");
    }else{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "userRegister");
        xhr.setRequestHeader("Content-Type", "application/json");

        // JSON data
        let user = {
            "fname": f,
            "lname": l,
            "email": e,
            "password": p,
            "mobile": m,
            "gender": g,
            "joinDate": joinDate
        };

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) { // Request is complete
                if (xhr.status === 200) {
                    alert("Success");
                    console.log("Response: " + xhr.responseText);
                } else if(xhr.status === 201){
                    alert("Success 201");
                    console.log("Response: " + xhr.responseText);
                } else {
                    alert("Request failed: " + xhr.statusText);
                    console.log("Request failed: " + xhr.statusText);
                }
            }
        };

        xhr.send(JSON.stringify(user));
    }
}
function ValidateEmail(inputText) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(inputText.match(mailformat)) {
        return true;
    }
    else
    {
        alert("You have entered an invalid email address!");
        return false;
    }
}


function signIn() {

    let email = document.getElementById("email2").value;
    let password = document.getElementById("password2").value;
    let rememberme = document.getElementById("rememberMe").checked;

    if(email == ""){
        alert("Email cannot be Empty");
    }else if(!ValidateEmail(email)){
        // alert("Email cannot be Empty");
    }else if(password == ""){
        alert("Password cannot be Empty");
    }else if(password.length <5 || password.length >20){
        alert("Invalid Password");
    }else{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "userLogin", true);
        xhr.setRequestHeader("Content-Type", "application/json");

        // JSON data
        let user = {
            "email": email,
            "password": password,
            "rememberMe": rememberme
        };

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) { // Request is complete
                if (xhr.status === 200 || xhr.status === 201) {

                    window.location = "";
                    console.log("Response: " + xhr.responseText);
                } else {
                    alert("Request failed: " + xhr.statusText);
                    console.log("Request failed: " + xhr.statusText);
                }
            }
        };

        xhr.send(JSON.stringify(user));
    }
}

var bm;

function fogotPassword() {
    var email = document.getElementById("email2");
    var r = new XMLHttpRequest();

    r.onreadystatechange = function() {

        if (r.readyState == 4) {
            var t = r.responseText;

            if (t == "Success") {

                alert("varification code has sent to your email. please check inbox.");

                if (bm1 != null) {
                    bm1.hide();
                }

                var m = document.getElementById("fogotPasswordModal");
                bm = new bootstrap.Modal(m);
                bm.show();

            } else {
                alert(t);
            }

        }

    }
    r.open("GET", "forgotPasswordProcess.php?e=" + email.value, true);
    r.send();
}

function showpassword1() {

    var np = document.getElementById("np");
    var npb = document.getElementById("npb");

    if (np.type == "password") {

        np.type = "text";
        npb.innerHTML = "<i class='bi-eye-fill'></i>";

    } else {

        np.type = "password";
        npb.innerHTML = "<i class='bi-eye-slash-fill'></i>";

    }

}

function showpassword2() {

    var np = document.getElementById("rnp");
    var npb = document.getElementById("rnpb");

    if (np.type == "password") {

        np.type = "text";
        npb.innerHTML = "<i class='bi-eye-fill'></i>";

    } else {

        np.type = "password";
        npb.innerHTML = "<i class='bi-eye-slash-fill'></i>";

    }

}

function resetpassword() {

    var e = document.getElementById("email2");
    var np = document.getElementById("np");
    var rnp = document.getElementById("rnp");
    var vc = document.getElementById("vc");

    var form = new FormData();
    form.append("e", e.value);
    form.append("np", np.value);
    form.append("rnp", rnp.value);
    form.append("vc", vc.value);

    var r = new XMLHttpRequest();

    r.onreadystatechange = function() {
        if (r.readyState == 4) {
            var t = r.responseText;

            if (t == "success") {
                alert("Password reset success");
                bm.hide();
                e.value = "";
                np.value = "";
                rnp.value = "";
                vc.value = "";

                signInModal();

            } else {
                alert(t);
            }
        }
    }

    r.open("POST", "resetPassword.php", true);
    r.send(form);
}

function signout() {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "userSignout", true);
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) { // Request is complete
                if (xhr.status === 200 || xhr.status === 201 || xhr.status === 204) {
                    // alert(xhr.responseText);
                    window.location = "";
                    console.log("Response: " + xhr.responseText);
                } else {
                    alert("Request failed: " + xhr.statusText);
                    console.log("Request failed: " + xhr.statusText);
                }
            }
        };

        xhr.send();
}

function viewpw() {
    var pwtxt = document.getElementById("pwtxt");
    var pwbtn = document.getElementById("viewpassword");

    if (pwtxt.type == "text") {

        pwtxt.type = "password";
        pwbtn.innerHTML = "<i class='bi bi-eye-fill'></i>";
    } else {
        pwtxt.type = "text";
        pwbtn.innerHTML = "<i class='bi bi-eye-slash-fill'></i>"
    }
}

function changeImage() {

    var view = document.getElementById("viewimg"); //image tag
    var file = document.getElementById("profileimg"); //file chooser

    file.onchange = function() {

        var file1 = this.files[0];
        var url1 = window.URL.createObjectURL(file1);
        view.src = url1;

    }


}

function update_profile() {
    let fname = document.getElementById("fn");
    let lname = document.getElementById("ln");
    let mobile = document.getElementById("mo");
    let line1 = document.getElementById("l1");
    if(document.getElementById("l1").value==""){
        line1 = document.getElementById("l11");
    }
    let line2 = document.getElementById("l2");
    if(document.getElementById("l2").value==""){
        line2 = document.getElementById("l22");
    }
    let city = document.getElementById("ci");
    let postal_code = document.getElementById("pc");
    let image = document.getElementById("profileimg").files[0];
    if (document.getElementById("profileimg").files.length == 0) {
        let confirmation = confirm("Are you sure you don't  want to update your profile picture?");
        if (confirmation) {
            alert("You have not selected any image");
        } else {}
    } else {
        // image = image.files[0];
    }

    // Convert image to base64
    let reader = new FileReader();
    reader.onload = function(event) {
        let base64Image = event.target.result;


    let xhr = new XMLHttpRequest();
    xhr.open("POST", "updateUserProfile");
    xhr.setRequestHeader("Content-Type", "application/json");
    // xhr.setRequestHeader("Content-Type", "multipart/form-data");
    // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // alert("in script 7");

        // JSON data
        let user = {
            "fname": fname.value,
            "lname": lname.value,
            "mobile": mobile.value,
            "line1": line1.value,
            "line2": line2.value,
            "city": city.value,
            "postal_code": postal_code.value,
            "image" : base64Image
        };

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) { // Request is complete
                if (xhr.status === 200 || xhr.status === 201) {
                    alert("Success");
                    console.log("Response: " + xhr.responseText);
                } else {
                    // alert("Request failed: " + xhr.statusText);
                    alert("User not recognized!...");
                    console.log("Request failed: " + xhr.status);
                }
            }
        };
        // console.log("User JSON to be sent: " + JSON.stringify(user));
        // Send the request
        xhr.send(JSON.stringify(user));
        // xhr.send(formData);
    };
    reader.readAsDataURL(image);
}

function changeProductImage() {

    var image = document.getElementById("imageuploader");

    image.onchange = function() {

        var img_count = image.files.length;

        for (var x = 0; x < img_count; x++) {

            var file = this.files[x];
            var url = window.URL.createObjectURL(file);
            document.getElementById("preview" + x).src = url;

        }



    }

}

function addproduct() {

    var category = document.getElementById("category");
    var author = document.getElementById("author");
    var publisher = document.getElementById("publisher");
    var title = document.getElementById("title");

    var condition = 0;

    if (document.getElementById("bn").checked) {
        condition = 1;
    } else if (document.getElementById("us").checked) {
        condition = 2;
    }


    var language = document.getElementById("lang");


    var edition = 0;

    if (document.getElementById("fprint").checked) {
        edition = 1;
    } else if (document.getElementById("rprint").checked) {
        edition = 2;
    }

    var hformat = 0;
    var eformat = 0;
    if (document.getElementById("hformat").checked) {
        hformat = 1;
    } else if (document.getElementById("eformat").checked) {
        eformat = 1;
    } else if (document.getElementById("hformat").checked && document.getElementById("eformat").checked) {
        hformat = 1;
        eformat = 1;
    }


    var pages = document.getElementById("pages");

    var description = document.getElementById("description");
    var image = document.getElementById("imageuploader").files[0];

    // Convert image to base64
    let reader = new FileReader();
    reader.onload = function(event) {
    let base64Image = event.target.result;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "addProductProcess");
    xhr.setRequestHeader("Content-Type", "application/json");

    // JSON data
    let product = {
        "category": category.value,
        "author": author.value,
        "publisher": publisher.value,
        "title": title.value,
        "condition": condition,
        "language": language.value,
        "edition": edition,
        "hformat": hformat,
        "eformat": eformat,
        "pages": pages.value,
        "description": description.value,
        "image" : base64Image,
    };

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) { // Request is complete
            if (xhr.status === 200 || xhr.status === 201) {
                alert("Success");
                window.location.reload();
                console.log("Response: " + xhr.statusText);
            } else {
                alert("Something went wrong!...");
                console.log("Response: " + xhr.statusText);
                console.log("Request failed: " + xhr.status);
            }
        }
    };
    xhr.send(JSON.stringify(product));
};
reader.readAsDataURL(image);
}

var em2;

function empRegModal() {

    // if (am1 != null) {
    //     am1.hide();
    // }

    var m2 = document.getElementById("empreg");
    em2 = new bootstrap.Modal(m2);
    em2.show();


}

function empReg() {
    var f = document.getElementById("fname");
    var l = document.getElementById("lname");
    var un = document.getElementById("uname");
    var e = document.getElementById("email");
    var p = document.getElementById("password");
    var m = document.getElementById("mobile");
    var g = document.getElementById("gender");
    var et = document.getElementById("emp_type");

    const currentDate = new Date();
    // "YYYY-MM-DD" format
    const formattedDate = formatDateToYYYYMMDD(currentDate);
    let hireDate = formattedDate;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "empRegProcess");
    xhr.setRequestHeader("Content-Type", "application/json");
    // JSON data
    let employee = {
        "fname": f.value,
        "lname": l.value,
        "uname": un.value,
        "email": e.value,
        "password": p.value,
        "mobile": m.value,
        "gender": g.value,
        "empType": et.value,
        "joinedDate": hireDate
    };
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) { // Request is complete
            if (xhr.status === 200 || xhr.status === 201) {
                alert("success");
                f.value = "";
                l.value = "";
                un.value = "";
                e.value = "";
                p.value = "";
                m.value = "";
                document.getElementById("msg").innerHTML = "";
                // signInModal();
                console.log("Response: " + xhr.responseText);
            } else {
                alert("Request failed: " + xhr.statusText);
                document.getElementById("msg").innerHTML = xhr.responseText;
                console.log("Request failed: " + xhr.statusText);
            }
        }
    };

    xhr.send(JSON.stringify(employee));
}

function update_emp_profile() {
    // alert("in");

    var fname = document.getElementById("fn");
    var lname = document.getElementById("ln");
    var mobile = document.getElementById("mo");
    var image = document.getElementById("profileimg");
    var form = new FormData();
    form.append("fn", fname.value);
    form.append("ln", lname.value);
    form.append("mo", mobile.value);
    // alert(image.files.length);
    if (image.files.length == 0) {

        var confirmation = confirm("Are you sure you don't  want to update your profile picture?");

        if (confirmation) {
            alert("You have not selected any image");
        } else {

        }

    } else {
        form.append("image", image.files[0]);
    }

    var r = new XMLHttpRequest();
    r.onreadystatechange = function() {
        if (r.readyState == 4) {
            var t = r.responseText;
            // alert(t);
            if (t == "Please Log In to your account first.") {
                alert("Please Log In to your account first");
                window.location = "index.php";
            } else if (t == "success") {
                window.location = "employeeProfile.php";
            } else {
                alert(t);
            }

        }
    }
    r.open("POST", "updateEmpProfileProcess.php", true);
    r.send(form);

}

function vendorRegister() {
    var name = document.getElementById("r_name").value;
    var mobile = document.getElementById("mno").value;
    var publication = document.getElementById("pub").value;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "vendorRegProcess");
    xhr.setRequestHeader("Content-Type", "application/json");
    // JSON data
    let vendor = {
        "name": name,
        "mobile": mobile,
        "publication": publication
    };
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) { // Request is complete
            if (xhr.status === 200 || xhr.status === 201) {
                alert("success");
                name = "";
                mobile = "";
                publication = "";

                window.location.reload();
                console.log("Response: " + xhr.responseText);
            } else {
                alert("Request failed: " + xhr.statusText);
                document.getElementById("msg").innerHTML = xhr.responseText;
                console.log("Request failed: " + xhr.statusText);
            }
        }
    };

    xhr.send(JSON.stringify(vendor));
}

function vendorUpdate() {
    window.location = "vendorUpdate.php";
}


function vendorUpdateProcess() {
    var id = document.getElementById("m_id").value;
    var name = document.getElementById("m_name").value;
    var mobile = document.getElementById("m_mno").value;
    var pub = document.getElementById("m_pub").value;

    let vendorData = {
        "id":id,
        "name":name,
        "mobile":mobile,
        "publication":pub
    }

    fetch("vendorUpdateProcess", {
        method:"POST",
        body:JSON.stringify(vendorData)
    }).then(response=>{
        if(!response.ok){
            throw new Error("Network Error..");
        }
        return response.text();
    }).then(data=>{
        if(data=="success"){
            alert("Update Success");
            fetch("vendorUpdate", {
                method: "GET"
            }).then(response => response.text())
                .then(data => {
                    document.open();
                    document.write(data);
                    document.close();
                });
        }else{
            alert(data);
        }
    }).catch(error=>{
        console.error("error", error);
    });

}

function spriceUpdate() {

    var id = document.getElementById("s_id").value;
    var sprice = document.getElementById("s_price").value;
    var dow = document.getElementById("dow").value;
    var doc = document.getElementById("doc").value;

    var b_price = document.getElementById("b_price").value;

    if (parseFloat(b_price) >= parseFloat(sprice)) {
        alert("Buying Price Cannot be greater than selling price..");
    } else {

        let updateData = {
            "id" : id,
            "sprice" : sprice,
            "dow" : dow,
            "doc" : doc
        }

        fetch("spriceUpdateProcess",
            {
                method:"POST",
                body:JSON.stringify(updateData)
            }
        )
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data => {
                if (data == "success") {
                    alert("Update Success");
                    window.location = "stock";
                } else {
                    alert(t);
                }
            })
            .catch(error => {
                console.error('Error:', error);
            });

    }

}

var xm;

function adminVerification() {
    let e = document.getElementById("em").value;

    if(e == ""){
        alert("Email cannot be Empty");
    }else if(!ValidateEmail(e)){
        // alert("Email cannot be Empty");
    }else{
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "adminVerificationProcess", true);
        xhr.setRequestHeader("Content-Type", "application/json");

        // JSON data
        let admin = {
            "email": e
        };

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4) { // Request is complete
                if (xhr.status === 200 || xhr.status === 201) {
                    var verificationModal = document.getElementById("verificationModal");
                    xm = new bootstrap.Modal(verificationModal);
                    xm.show();
                    console.log("Response: " + xhr.responseText);
                } else {
                    alert("Employee email does not exist...");
                    console.log("Request failed: " + xhr.statusText);
                }
            }
        };

        xhr.send(JSON.stringify(admin));
    }

}

function verify() {
    let vcode = document.getElementById("vcode").value;
    if(vcode==""){
        alert("Verification code cannot be empty.")
    }
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            alert(xhr.status);
            alert("status code ."+xhr.status);
            if (xhr.status === 200) {
                xm.hide();
                // window.location = "adminpanel";
                fetch("adminPanel", {
                    method: "GET"
                }).then(response => response.text())
                    .then(data => {
                        document.open();
                        document.write(data);
                        document.close();
                    });
            } else {
                // Handle other error cases
                alert(xhr.responseText);
                console.log("An error occurred.");
            }
        }
    };

    xhr.open("GET", "verifyProcess?verificationCode=" + vcode, true);
    xhr.send();

}

function basicSearchHome(x) {

    var txt = document.getElementById("basic_search_txt");
    var select = document.getElementById("basic_search_select");

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "basicSearchHomeProcess");
    xhr.setRequestHeader("Content-Type", "application/json");

    // JSON data
    let bSearch = {
        "txt": txt.value,
        "select": select.value,
        "page": x
    };

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) { // Request is complete
            if (xhr.status === 200 || xhr.status === 201) {
                // alert("Success");

                var parser = new DOMParser();
                var htmlDoc = parser.parseFromString(xhr.responseText, 'text/html');
                console.log(htmlDoc);

                document.getElementById("basicSearchResult").innerHTML = htmlDoc.body.innerHTML;
                // document.getElementById("basicSearchResult").innerHTML = xhr.responseText;
                console.log("Response: " + xhr.responseText);
            } else {
                alert("Request failed: " + xhr.statusText);
                console.log("Request failed: " + xhr.statusText);
            }
        }
    };

    xhr.send(JSON.stringify(bSearch));
}

// feedback
var inv_bid = 0;
var modal;

function feedback(id) {
    inv_bid = id;
    var m = document.getElementById("exampleModal");
    modal = new bootstrap.Modal(m);
    modal.show();
}

// feedback

// saveFeedback

function saveFeedback() {
    var feedback = document.getElementById("fbk").value;

    var f = new FormData();
    f.append("id", inv_bid);
    f.append("f", feedback);

    var r = new XMLHttpRequest();
    r.onreadystatechange = function() {
        if (r.readyState == 4) {
            var t = r.responseText;
            if (t == "success") {
                alert("Thank you for your valuable feedback.");
                window.location.reload();
            } else {
                alert(t);
            }
        }
    };

    r.open("POST", "feedbackProcess.php", true);
    r.send(f);
}

// saveFeedback

function basicSearchWatchlist(x, email) {

    var txt = document.getElementById("txt");

    var f = new FormData();
    f.append("t", txt.value);
    f.append("page", x);
    f.append("email", email);

    var r = new XMLHttpRequest();

    r.onreadystatechange = function() {
        if (r.readyState == 4) {
            var t = r.responseText;
            document.getElementById("resultPage").innerHTML = t;
        }
    }

    r.open("POST", "basicSearchWachlistProcess.php", true);
    r.send(f);

}


function basicSearch(x) {

    var txt = document.getElementById("basic_search_txt");
    var select = document.getElementById("basic_search_select");

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "basicSearchProcess");
    xhr.setRequestHeader("Content-Type", "application/json");

    // JSON data
    let bSearch = {
        "txt": txt.value,
        "select": select.value,
        "page": x
    };

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) { // Request is complete
            if (xhr.status === 200 || xhr.status === 201) {
                // alert("Success");

                var parser = new DOMParser();
                var htmlDoc = parser.parseFromString(xhr.responseText, 'text/html');
                console.log(htmlDoc);

                document.getElementById("basicSearchResult").innerHTML = htmlDoc.body.innerHTML;
                // document.getElementById("basicSearchResult").innerHTML = xhr.responseText;
                console.log("Response: " + xhr.responseText);
            } else {
                alert("Request failed: " + xhr.statusText);
                console.log("Request failed: " + xhr.statusText);
            }
        }
    };

    xhr.send(JSON.stringify(bSearch));
}

var ttm;

function testModal() {

    var m = document.getElementById("testModal");
    ttm = new bootstrap.Modal(m);
    ttm.show();

}

function setId(id, name) {

    document.getElementById("bookID").innerHTML = id;
    document.getElementById("bookName").innerHTML = name;
    ttm.hide();

}

function advancedSearch(x) {
    var search_txt = document.getElementById("s1");
    var category = document.getElementById("c1");
    var author = document.getElementById("au1");
    var publisher = document.getElementById("pub1");
    var condition = document.getElementById("con");
    var language = document.getElementById("lang");
    var price_from_txt = document.getElementById("pf");
    var price_to_txt = document.getElementById("pt");
    var sort = document.getElementById("sort");

    var form = new FormData();
    form.append("page", x);
    form.append("s", search_txt.value);
    form.append("c", category.value);
    form.append("au", author.value);
    form.append("pub", publisher.value);
    form.append("c1", condition.value);
    form.append("lang", language.value);
    form.append("p1", price_from_txt.value);
    form.append("p2", price_to_txt.value);
    form.append("s1", sort.value);

    var r = new XMLHttpRequest();

    r.onreadystatechange = function() {
        if (r.readyState == 4) {
            var t = r.responseText;
            // alert(t);
            document.getElementById("view_area").innerHTML = t;
        }
    }

    r.open("POST", "advancedSearchProcess.php", true);
    r.send(form);


}

function check_value(qty) {

    var input = document.getElementById("qtyinput").value;
    alert(input);
    if (input <= 0) {
        alert("Product quantity must be greater than 1.");
        document.getElementById("qtyinput").value = "1";
    } else if (input > qty) {
        alert("Insufficient quantity.");
        document.getElementById("qtyinput").value = qty;
    }

}

function qty_inc(qty) {

    var input = document.getElementById("qtyinput");

    if (input.value < qty) {
        var newValue = parseInt(input.value) + 1;
        input.value = newValue.toString();
    } else {
        alert("Maximum quantity has achieved.");
    }

}

function qty_dec() {

    var input = document.getElementById("qtyinput");

    if (input.value > 1) {
        var newValue = parseInt(input.value) - 1;
        input.value = newValue.toString();
    } else {
        alert("Minimum quantity has achieved.");
    }

}

function addToCart(id) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status == 200 || xhr.status == 201) {
                alert("Add to cart successful..");
            } else {
                // Handle other error cases
                alert("Err :"+xhr.responseText);
                console.log("An error occurred.");
                console.log("status code ."+xhr.status);
            }
        }
    };

    xhr.open("GET", "addToCartProcess?id=" + id, true);
    xhr.send();
}

function deleteFromCart(id) {


    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
            if (xhr.status == 200 || xhr.status == 201) {
                alert("Product removed from the cart.");
                fetch("cart", {
                    method: "GET"
                }).then(response => response.text())
                    .then(data => {
                        document.open();
                        document.write(data);
                        document.close();
                    });
            } else {
                // Handle other error cases
                alert("Err :"+xhr.responseText);
                console.log("An error occurred.");
                console.log("status code ."+xhr.status);
            }
        }
    };

    xhr.open("GET", "removeCartProcess?id=" + id, true);
    xhr.send();

}

function addToWatchlist(id) {

    fetch("addToWatchlistProcess?id=" + id)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            // return response.json();
            return response.text();
        })
        .then(data => {
            if (data == "added") {

                document.getElementById("heart" + id).style.color = "red";
                window.location.reload();

            } else if (data == "removed") {

                document.getElementById("heart" + id).style.color = "white";
                window.location.reload();

            } else {

                alert(data);

            }
        })
        .catch(error => {
            console.error('Error:', error);
        });

}

function removeFromWatchlist(id) {

    fetch("addToWatchlistProcess?id=" + id, {
        method: "GET"
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            if (data == "removed") {
                window.location.reload();
            } else {
                alert(data);
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });

}

function buyNow(id, iqty, uprice) {
    // var qty = document.getElementById("qtyinput").value;
    // var unit_price = document.getElementById("unitprice").value;

    var qty = iqty;
    var unit_price = uprice;

    var f = new FormData();
    f.append("pid", id);
    f.append("pqty", qty);
    f.append("uprice", unit_price);

    var r = new XMLHttpRequest();
    r.onreadystatechange = function() {
        if (r.readyState == 4) {

            var responce = r.responseText;
            window.location = "invoice.php?order_id=" + responce;

        }
    }
    r.open("POST", "buyNowProcess.php", true);
    r.send(f);
}

function printInvoice() {

    var page = document.getElementById("page").innerHTML;
    var restorePage = document.body.innerHTML;
    document.body.innerHTML = page;
    window.print();
    document.body.innerHTML = restorePage;

}

function paynowproduct(image, id) {
    var title = document.getElementById("ptitle").innerHTML;
    var amount = document.getElementById("unitprice").innerHTML;
    var qty = document.getElementById("qtyinput").value;
    // var img = document.getElementById("productImg").value;
    var img = image;

    var t = parseInt(amount);
    var q = parseInt(qty);
    // alert(q);

    var price = t * q;

    window.location = "checkout?item_name=" + title + "&unitprice=" + amount + "&inputQty=" + qty + "&sid=" + id + "&price=" + price + "&image=" + img;
}

var pm;

function viewProductModal(id) {

    var m = document.getElementById("viewproductmodal" + id);
    pm = new bootstrap.Modal(m);
    pm.show();

}

var cm;

function addNewcategory() {

    var m = document.getElementById("addCategoryModal");
    cm = new bootstrap.Modal(m);
    cm.show();

}

var cvm;
var newCategory;
var uemail;

function categoryVerifyModal() {
    var m = document.getElementById("addCategoryModalVerification");
    cvm = new bootstrap.Modal(m);
    newCategory = document.getElementById("n").value;
    uemail = document.getElementById("e").value;

    let data = {
        "newCategory":newCategory,
        "email":uemail
    }

    fetch("addNewCategoryProcess", {
        method:"POST",
        body:JSON.stringify(data)
    }).then(response=>{
        if(!response.ok){
            throw new Error("network error..");
        }
        return response.text();
    }).then(data=>{
        if(data=="success"){
            cm.hide();
            cvm.show();
        }
    }).catch(error=>{
        console.error("Erorr : ", error);
    });

}

function saveCategory() {
    var text = document.getElementById("t").value;

    let data = {
        "text":text,
        "newCategory":newCategory,
        "email":uemail
    }
    fetch("saveNewCategoryProcess", {
        method:"POST",
        body:JSON.stringify(data)
    }).then(response=>{
        if(!response.ok){
            throw new Error("Network error");
        }
        return response.text();
    }).then(data=>{
        if(data == "success"){
            location.reload();
        }else{
            alert(data);
        }
    }).catch(error=>{
        console.error("error", error);
    });
}

var dvm;
var category_id;
var e_email;

function deleteCategoryVerify(email, c_id) {
    var m = document.getElementById("deleteCategoryModalVerification");
    dvm = new bootstrap.Modal(m);
    category_id = c_id;
    e_email = email;

    fetch("deleteVerificationCategoryProcess?email=" + email, {
        method:"GET"
    }).then(response=>{
        if(!response.ok){
            throw new Error("Network error");
        }
        return response.text();
    }).then(data=>{
        if(data=="success"){
            dvm.show();
        }else{
            alert(data);
        }
    }).catch(error=>{
        console.error("Error", error);
    });

}

function deleteCategory() {

    var vt = document.getElementById("vt").value;

    fetch("deleteCategoryProcess?email=" + e_email + "&vt=" + vt + "&id=" + category_id, {
        method:"GET",
    }).then(response=>{
        if(!response.ok){
            throw new Error("Network Error");
        }
        return response.text();
    }).then(data=>{
        if(data=="success"){
            alert(data);
            location.reload();
        }else{
            alert(data);
        }
    }).catch(error=>{
        console.error("Error", error);
    });

}

var mm;

function viewmsgmodal() {
    var m = document.getElementById("viewMsgModal");
    mm = new bootstrap.Modal(m);
    mm.show();
}

function userBlock(email) {
    fetch("userBlockProcess?email=" + email, {
        method:"GET"
    }).then(response=>{
        if(!response.ok){
            throw new Error("Network Error..");
        }
        return response.text();
    }).then(data=>{
        location.reload();
    }).catch(error=>{
        console.error("Error", error);
    });
}

function empBlock(email) {
    fetch("empBlockProcess?email=" + email, {
        method:"GET"
    }).then(response=>{
        if(!response.ok){
            throw new Error("Network Error..");
        }
        return response.text();
    }).then(data=>{
        location.reload();
    }).catch(error=>{
        console.error("Error", error);
    });
}

function vendorBlock(id) {
    fetch("vendorBlockProcess?id=" + id, {
        method:"GET"
    }).then(response=>{
        if(!response.ok){
            throw new Error("Network Error");
        }
        return response.text();
    }).then(data=>{
        location.reload();
    }).catch(error=>{
        console.error("error", error);
    });
}

function changeInvoiceId(id) {
    fetch("changeInvoiceIDProcess?id=" + id, {
        method:"GET"
    }).then(response=>{
        if(!response.ok){
            alert("response status : "+response.status);
            throw new Error("Network Error");
        }
        return response.text();
    }).then(data=>{
        location.reload();
    }).catch(error=>{
        console.error("error", error);
    });
}