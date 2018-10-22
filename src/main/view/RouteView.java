package main.view;


import main.controller.RouteController;

import java.io.IOException;


public class RouteView {
    RouteController routeController;
    TrainView trainView;

    public RouteView() {
        routeController = new RouteController();
        trainView = new TrainView();
    }

    public void searchByRouteAndDate(String departure, String destination, String date) throws IOException {
        trainView.searchByTrainNumber(
                routeController.searchByRouteAndDate(departure, destination, date));
    }
}
