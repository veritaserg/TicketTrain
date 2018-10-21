package main.view;


import main.controller.RouteController;

import java.io.IOException;

public class RouteView {
RouteController routeController = new RouteController();
TrainView trainView;

public void searchByRouteAndDate (String departure,String destination, String date) {
    trainView = new TrainView();
    trainView.searchByTrainNumber(
            routeController.searchByRouteAndDate(departure, destination, date));




}}
