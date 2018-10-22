package main.repository.builder;



import main.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.*;

public class Builder {
    static String pathRoute = "C:\\Users\\server\\IdeaProjects\\TicketTrain\\src\\main\\resource\\route.csv";
    static String pathCar = "C:\\Users\\server\\IdeaProjects\\TicketTrain\\src\\main\\resource\\car.csv";
    static String pathTrain ="C:\\Users\\server\\IdeaProjects\\TicketTrain\\src\\main\\resource\\train.csv";
    static Path paths;

    public static void main(String[] args) throws IOException {
        creatAll();
    }

    public static void creatAll() throws IOException {
//        creatCar();
//        creatTrain();
        creatRoute();
    }

    public static void creatRoute() throws IOException {
        Map<Location,LocalDateTime> locations = new HashMap<>();
        paths = Paths.get(pathRoute);
        LocalDateTime timeDeparture = LocalDateTime.of(2018, 10, 15, 22, 00);
        LocalDateTime timeDestination = LocalDateTime.of(2018, 10, 16, 06, 00);
        Location kiev = new Location((long) 1,"Kiev");
        Location odessa = new Location((long) 1,"Odessa");
        locations.put(odessa,timeDestination);
        locations.put(kiev,timeDeparture);

        List<String> list = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(Paths.get(pathTrain))) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }

            String numberTrain = list.get(0).split(",")[1];

            Route route = new Route((long) 1,locations,numberTrain);

            String routeString = route.getId()+","+ route.getLocations() +"," + route.getNumberTrain() + "\n";
            Files.write(paths, routeString.getBytes(), StandardOpenOption.APPEND);

        }
    }

    public static void creatCar() throws IOException {
        Path paths = Paths.get(pathCar);
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car((long) 1, Type.ECONOMY, 25);
        Car car2 = new Car((long) 2, Type.COUPE, 20);
        Car car3 = new Car((long) 3, Type.SV, 15);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);


        for (Car car : cars) {
            String carString = car.getId() + "," + car.getType() + ", " + carSeat(car) + "\n";
            Files.write(paths, carString.getBytes(), StandardOpenOption.APPEND);

        }

    }

    public static String carSeat(Car car) {
        String seat = String.valueOf(car.getSeatAll());
        seat = seat.substring(1, seat.length() - 1);
        return seat;
    }

    public static void creatTrain() throws IOException {
        paths = Paths.get(pathTrain);
        List<Long> carNamber = new ArrayList<>();
        for (Car number : getCars()) {
            carNamber.add(number.getId());
    }


        Train train = new Train((long) 1,"345",carNamber);
        String car = String.valueOf(train.getCarNamber());
        car = car.substring(1, car.length() - 1);
        String trainString =train.getId()+","+ train.getNamber() + ", " + car + "\n";
        Files.write(paths, trainString.getBytes(), StandardOpenOption.APPEND);

    }

    public static List<Car> getCars() throws IOException {
        Integer numberCar;
        Type type = null;
        Status status = Status.OPEN;
        Map<Integer, Status> seats = null;
        paths = Paths.get(pathTrain);
        List<String> list = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(Paths.get(pathCar))) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }
        }
        List<Car> cars = new ArrayList<>();
        for (String car : list) {
            numberCar = Integer.parseInt(car.split(",")[0]);
            switch (car.split(",")[1]) {
                case "ECONOMY":
                    type = Type.ECONOMY;
                    seats = getStatus(51, status, seats, car);
                    break;
                case "COUPE":
                    type = Type.COUPE;
                    seats = getStatus(41, status, seats, car);
                    break;
                case "SV":
                    type = Type.SV;
                    seats = getStatus(31, status, seats, car);
                    break;
            }

            Car car1 = new Car(Long.valueOf(numberCar), type, seats);
            cars.add(car1);
        }
        return cars;
    }

    public static Map<Integer, Status> getStatus(int size, Status status, Map<Integer, Status> seats, String car) {
        seats = new HashMap<>();
        for (int i = 2; i < size; i = i + 2) {
            String j = car.split(",")[i];
            Integer seat = Integer.valueOf(j.trim());
            String st = car.split(",")[i + 1];
            if (st.equals("CLOUSE"))
                status = Status.CLOUSE;
            if (st.equals("OPEN"))
                status = Status.OPEN;
            seats.put(seat, status);
        }
        return seats;
    }
}