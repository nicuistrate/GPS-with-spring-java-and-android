/**
 * Created with IntelliJ IDEA.
 * User: Vig Marian
 * Date: 12/2/19
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */

function sendRequest (type, resource, data, successHandler, errHandler) {
    jQuery.ajax({
        type: type,
        url: "http://localhost:8081/" + resource,
        data: data,
        dataType: "json",
        accepts: "application/json",

        success: function (data, status, jqXHR) {
            successHandler (data);
        },

        error: function (jqXHR, status) {
            errHandler(status);
        }
    });
}
function sendNewRequest(type, resource, data, successHandler, errHandler) {
    var terminalID = document.getElementById("deviceId").value;
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;

    console.log(sessionStorage.getItem('token'));

    jQuery.ajax({
        type: type,
        url: "http://localhost:8081/" + resource,
        data: data,
        headers: {"Authorization":"Bearer "+sessionStorage.getItem('token')},
        dataType: "json",
        accepts: "application/json",

        success: function (data, status, jqXHR) {
            successHandler (data);
        },

        error: function (jqXHR, status) {
            errHandler(status);
        }
    });
}
function goToPage(url) {
    $(location).attr('href',url);
}

function savePosition(position){
    jQuery.ajax({
        type: "POST",
        url: "http://localhost:8081/position/send?",
        data: JSON.stringify(position),
        headers: {
            "Authorization":"Bearer "+sessionStorage.getItem('token'),
            'Accept': 'application/json',
            'Content-Type': 'application/json' },
        dataType: "json",

        success: function (data, status, jqXHR) {
            console.log(data);
        },

        error: function (jqXHR, status) {
            console.log(status);
            console.log(jqXHR);
        }
    });
}