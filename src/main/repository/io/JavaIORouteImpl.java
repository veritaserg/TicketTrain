package main.repository.io;


import main.model.Location;
import main.model.Route;
import main.repository.RouteRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaIORouteImpl implements RouteRepository {
    static String pathRoute = "src\\main\\resource\\route.csv";

    @Override
    public void create(Route route) {

    }

    @Override
    public void update(Route route) {

    }

    @Override
    public Route getById(Long aLong) {
        return null;
    }

    public List<Route> getAll() {
        Map<Location,LocalDateTime> locations = new HashMap<>();
int year;
int monthDeparture;
int monthDestination;
int dayDeparture;
int dayDestination;
int hourDeparture;
int hourDestination;
String minuteDeparture;
String minuteDestination;

Long id =0L;
        String departure;
        String destination;
        LocalDateTime departureDate;
        LocalDateTime destinationDate;
        String numberTrain;
        Route route;
        List<Route> routes = new ArrayList<>();
        List<String> list = new ArrayList<>();
        try (BufferedReader   bf = Files.newBufferedReader(Paths.get(pathRoute))) {
            while (bf.ready()) {
                list.add(bf.readLine()); }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String car : list) {
           id = Long.valueOf(car.split(",")[0]);
                 departure = car.split(",")[1].substring(1);
           destination = car.split(",")[3].trim();
                       String dataDep = car.split(",")[2];
            String dataDes = car.split(",")[4];
         year = Integer.parseInt(dataDep.substring(1,5));
      monthDeparture = Integer.parseInt(dataDep.substring(6,8));
       dayDeparture = Integer.parseInt(dataDep.substring(9,11));
       hourDeparture = Integer.parseInt(dataDep.substring(12,14));
minuteDeparture = dataDep.substring(15);


                     monthDestination = Integer.parseInt(dataDes.substring(6,8));
          dayDestination = Integer.parseInt(dataDes.substring(9,11));
         hourDestination = Integer.parseInt(dataDes.substring(12,14));
          minuteDestination = dataDes.substring(15,17);

            departureDate = LocalDateTime.of(year,monthDeparture,dayDeparture,hourDeparture, Integer.parseInt(minuteDeparture));
            destinationDate = LocalDateTime.of(year,monthDestination,dayDestination,hourDestination, Integer.parseInt(minuteDestination));

            numberTrain = car.split(",")[5];
            Location depart = new Location((long) 1,departure);
            Location destin = new Location((long) 1,destination);
            locations.put(destin,departureDate);
            locations.put(depart,destinationDate);

route = new Route(id,locations,numberTrain);
routes.add(route);

        }
              return routes;
    }
}
