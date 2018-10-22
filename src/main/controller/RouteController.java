package main.controller;


import main.model.Route;
import main.service.RouteService;

import java.io.IOException;

public class RouteController {
    RouteService routeService;
    public RouteController(){
        routeService = new RouteService();
    }



    public String searchByRouteAndDate(String departure,String destination,String date) throws IOException {
        return routeService.searchByRouteAndDate(departure,destination,date);
    }
    public Route getRoute(String departure, String destination) throws IOException {
        Route route =routeService.getRoute(departure,destination);

      return route;
    }
}
