package main.service;
import main.model.Route;
import main.repository.RouteRepository;
import main.repository.io.JavaIORouteImpl;

import java.io.IOException;
import java.util.List;

public class RouteService {
    RouteRepository routeRepository;
public RouteService(){
    routeRepository = new JavaIORouteImpl();
}


    public String searchByRouteAndDate(String departure, String destination, String date) {
        List<Route> routes = null;
        try {
            routes = routeRepository.getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dateDeparture;
        String departureRout;
        String destinationRout;
        for (Route route : routes) {
            dateDeparture = String.valueOf(route.getLocations()).split(",")[1].substring(9, 11) +
                    "/" + String.valueOf(route.getLocations()).split(",")[1].substring(6, 8);
            destinationRout = String.valueOf(route.getLocations()).split(",")[0].substring(1);
            departureRout = String.valueOf(route.getLocations()).split(",")[2].trim();
            if (departure.equals(departureRout) && destination.equals(destinationRout) && date.equals(dateDeparture)) {
                return route.getNumberTrain();
            }

        }
        return null;
    }
    public Route getRoute(String departure, String destination){
        List<Route> routes = null;
        try {
            routes = routeRepository.getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String departureRout;
        String destinationRout;
        for (Route route : routes) {

            departureRout = String.valueOf(route.getLocations()).split(",")[0].substring(1);
            destinationRout = String.valueOf(route.getLocations()).split(",")[2].trim();
            if (departure.equals(departureRout) && destination.equals(destinationRout)) {
                return route;
            }

        }
        return null;

    }



}

