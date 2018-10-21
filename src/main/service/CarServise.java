package main.service;


import main.model.Car;
import main.model.Status;
import main.model.Type;
import main.repository.CarRepository;
import main.repository.io.JavaIOCarImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarServise {
    CarRepository carRepository;

    public CarServise() {
        carRepository = new JavaIOCarImpl();
    }
    public List<Car> getCarByNumber(List<Integer> carNumber) throws IOException {
        List<Car> carAll =  carRepository.getAll();
        List<Car> cars = new ArrayList<>();
         for (int i = 0; i < carAll.size();i++){
          for (int j = 0; j < carNumber.size();j++){
          if (carAll.get(i).getId().equals(carNumber.get(j))){
              cars.add(carAll.get(i));
                        }}
      }
return cars;
    }
    public Map<Long, List<Integer>> getSeatsStatusOpen(List<Car> cars, String type) {

        Map<Long, List<Integer>> carfree = new HashMap<>();
        switch (type) {
            case "ECONOMY":
                for (Car car : cars) {
                    if (car.getType().equals(Type.ECONOMY))
                        carfree.put(car.getId(),car.getSeatsStatusOpen());
                }
                break;
            case "COUPE":
                for (Car car : cars) {
                    if (car.getType().equals(Type.COUPE))
                        carfree.put(car.getId(), car.getSeatsStatusOpen());

                }
                break;
            case "SV":
                for (Car car : cars) {
                    if (car.getType().equals(Type.SV))
                        carfree.put(car.getId(), car.getSeatsStatusOpen());

                }
                break;
            default:

        }
        return carfree;

    }

    public void changeStatus(int carNumber,int seatNumber) {
        try {
            List<Car> cars = carRepository.getAll();
            for (Car car : cars) {
                if (car.getId().equals(carNumber)) {
                    for (Map.Entry<Integer, Status> seats : car.getSeats().entrySet()) {
                        if (seats.getKey().equals(seatNumber)) {
                            if (seats.getValue().equals(Status.OPEN)) {
                                seats.setValue(Status.CLOUSE);
                            } else {
                                seats.setValue(Status.OPEN);
                            }
                        }
                    }
                }

            }
            carRepository.save(cars);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }}