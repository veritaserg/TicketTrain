package main.view;



import main.controller.TrainController;

import java.util.List;

public class TrainView {
    TrainController trainController = new TrainController();
CarView carView;
    public void searchByTrainNumber(String numberTrain){
        carView = new CarView();
        List<Long> numberCar =
        trainController.getCarNumberByTrainNumber(numberTrain);
carView.getSeatsStatusOpen(numberCar);

    }
}
