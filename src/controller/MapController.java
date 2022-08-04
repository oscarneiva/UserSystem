package controller;

public class MapController {

    public MapController(){

    }

    public void getRoute(String origin, String destination){
        origin = origin.replace(" ","+");
        destination = destination.replace(" ","+");

        String request = "https://maps.googleapis.com/maps/api/directions/json?origin="+ origin +"&destination=" + destination + "&key=";
        System.out.println(request);
    }
}
