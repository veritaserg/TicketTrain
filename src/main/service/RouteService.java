package main.service;
import main.model.Route;
import main.repository.RouteRepository;
import main.repository.io.JavaIORouteImpl;
import java.util.List;

public class RouteService {
    RouteRepository routeRepository = new JavaIORouteImpl();

    public String searchByRouteAndDate(String departure, String destination, String date) {
        List<Route> routes = routeRepository.getAll();
        String dateDestinetion;
        String departureRout;
        String destinationRout;
        for (Route route : routes) {
            dateDestinetion = String.valueOf(route.getLocations()).split(",")[3].substring(9, 11) +
                    "/" + String.valueOf(route.getLocations()).split(",")[3].substring(6, 8);
            departureRout = String.valueOf(route.getLocations()).split(",")[0].substring(1);
            destinationRout = String.valueOf(route.getLocations()).split(",")[2].trim();
            if (departure.equals(departureRout) && destination.equals(destinationRout) && date.equals(dateDestinetion)) {
                return route.getNumberTrain();
            }
            return route.getNumberTrain();
        }
        return null;
    }



}

