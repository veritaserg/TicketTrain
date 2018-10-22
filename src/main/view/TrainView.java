package main.view;



import main.controller.TrainController;

import java.util.List;

public class TrainView {
    TrainController trainController;
CarView carView;

public TrainView(){
    trainController = new TrainController();
    carView = new CarView();
}

    public void searchByTrainNumber(String numberTrain){
            List<Long> numberCar =
        trainController.getCarNumberByTrainNumber(numberTrain);
        System.out.println(numberCar);
carView.getSeatsStatusOpen(numberCar);

    }
}
