
function validate(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    // var token = 'proiectscdjwt';
    var token;

    $.ajax({
        url: "http://localhost:8081/authenticate",
        type: "POST",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            username: username,
            password: password,
        }),
        success: function (res) {
            token = res.token;
            console.log(token);

            sessionStorage.setItem('token',token);
            //alert('success');
            console.log(sessionStorage.getItem('token'));
            goToPage('index.html');
            sessionStorage.setItem('token',token)

        },

    });
    //window.location = "index.html";
}

var firstClick=false;

function initialclick() {
    if (firstClick)
        return;
    var username = document.getElementById("username");
    var password = document.getElementById( "password");
    password.value = "";
    username.value = "";
    firstClick=true;

    username.style.color = "#000000";
    password.style.color = "#000000";

}
function register(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    $.ajax({
        url: "http://localhost:8081/register",
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify({
            username: username,
            password: password,
        }),
        success: function (result) {
            alert('success');
        }
    });
    document.getElementById("username").value="";
    document.getElementById("password").value="";
}
