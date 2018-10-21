package main.service;

import main.model.Train;
import main.repository.TrainRepository;
import main.repository.io.JavaIOTrainImpl;
import java.util.List;

public class TrainService {
    TrainRepository trainRepository;
        public TrainService() {
        TrainRepository trainRepository = new JavaIOTrainImpl();
    }
 public List<Long> getCarNumberByTrainNumber(String number) {
       Train train = trainRepository.getById(number);
           return train.getCarNamber();

}



}
