/**
 * Created with IntelliJ IDEA.
 * User: Vig Marian
 * Date: 12/2/19
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
function getPositions() {
    var criteria = new Criteria();
    sendNewRequest("GET", "position/getAll?" + $.param(criteria), null, getPositionsSuccessHandler, getPositionsErrorHandler);
}

function Criteria() {
    var terminal_id = $('#deviceId').val().trim(); // select data from input and trim it
    if (terminal_id.length > 0) {
        this.terminal_id = terminal_id;
    }

    var startDate = $('#startDate').val().trim(); // select data from input and trim it
    if (startDate.length > 0) {
        this.startDate = startDate;
    }

    var endDate = $('#endDate').val().trim(); // select data from input and trim it
    if (endDate.length > 0) {
        this.endDate = endDate;
    }
}

function getPositionsSuccessHandler(respData) {
    $("#result").append("<br>" + JSON.stringify(respData));

    var i = 0;
    for (var aux in respData){
        sessionStorage.setItem('lat' + i, respData[aux].latitude);
        sessionStorage.setItem('long' + i, respData[aux].longitude);
        sessionStorage.setItem('index',i);
        i++;
    }

    //$("#result").text(respData); // appends the json to the 'result' div. see index.html
}

function getPositionsErrorHandler(status) {
    alert("err response: " + status); // popup on err.
}


function addStaticMarker() {

    for(var i=0;i<parseInt(sessionStorage.getItem('index'))+1;i++){
        var pos = {lat: parseFloat(sessionStorage.getItem('lat' + i)), lng: parseFloat(sessionStorage.getItem('long' + i))};
        var marker = new google.maps.Marker({
            position: getRandomPosition(),
            map: map,
            title: 'Hello World!'
        });
        marker.setMap(map);
    }

}


function getRandomPosition(){
    var randLatLng = {lat: (myLatLng["lat"] + Math.floor(Math.random() * 5) + 1),
        lng: (myLatLng["lng"] + Math.floor(Math.random() * 5) + 1)};
    return randLatLng;
}
var map;
var myLatLng = {lat: 44.4361414, lng: 26.1027202};

function initialize() {
    var mapCanvas = document.getElementById('map');
    var mapOptions = {
        center: new google.maps.LatLng(myLatLng),
        zoom: 8,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }

    map = new google.maps.Map(mapCanvas, mapOptions)
}