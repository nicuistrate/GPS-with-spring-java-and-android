/**
 * Created with IntelliJ IDEA.
 * User: Vig Marian
 * Date: 12/2/19
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
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



