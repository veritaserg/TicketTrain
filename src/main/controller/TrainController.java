package main.controller;


import main.service.TrainService;

import java.util.List;

public class TrainController {

    TrainService trainService;
    public TrainController(){
        trainService = new TrainService();
    }

    public List<Long> getCarNumberByTrainNumber(String numberTrain){
        return trainService.getCarNumberByTrainNumber(numberTrain);
    }
}
