package main.view;


import main.controller.RouteController;



public class RouteView {
RouteController routeController;
TrainView trainView;
public RouteView(){
    routeController = new RouteController();
    trainView = new TrainView();
}

public void searchByRouteAndDate (String departure,String destination, String date) {

    trainView.searchByTrainNumber(
            routeController.searchByRouteAndDate(departure, destination, date));




}}
