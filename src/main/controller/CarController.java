package main.controller;


import main.model.Car;
import main.service.CarServise;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CarController {
    CarServise carServise = new CarServise();

    public List<Car> getCarByNumber(List<Integer> carNumber){
        try {
            return carServise.getCarByNumber(carNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    public Map<Integer, List<Integer>> getSeatsStatusOpen(List<Car> cars, String type){
      return carServise.getSeatsStatusOpen(cars,type);
    }
    public void changeStatus(int carNumber,int seatNumber){
        carServise.changeStatus(carNumber,seatNumber);
    }



}
