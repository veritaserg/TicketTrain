package main.controller;


import main.model.Route;
import main.service.RouteService;

public class RouteController {
    RouteService routeService;
    public RouteController(){
        routeService = new RouteService();
    }

    public String searchByRouteAndDate(String departure,String destination,String date){
        return routeService.searchByRouteAndDate(departure,destination,date);
    }
    public Route getRoute(String departure, String destination){
      return routeService.getRoute(departure,destination);
    }
}
