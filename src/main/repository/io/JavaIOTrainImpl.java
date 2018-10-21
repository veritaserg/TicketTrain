package main.repository.io;

import main.model.Train;
import main.repository.TrainRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaIOTrainImpl implements TrainRepository {
    static String pathTrain = "C:\\Users\\server\\IdeaProjects\\ templates\\com\\sergeev\\TrainTicket\\src\\main\\resource\\train.csv";

    @Override
    public void create(Train train) {

    }

    @Override
    public void update(Train train) {

    }

    @Override
    public Train getById(Long id) {
      String number;
        Train train = null;
        List<Long> carNamber = new ArrayList<>();

        List<String> list = new ArrayList<>();
        try (BufferedReader bf = Files.newBufferedReader(Paths.get(pathTrain))) {
            while (bf.ready()) {
                list.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String listTrain : list) {
                      if (listTrain.split(",")[0].equals(String.valueOf(id))) {
                number = listTrain.split(",")[1];
                try {
                    int i = 2;
                    while (true) {
                        carNamber.add(Long.valueOf(Integer.valueOf(listTrain.split(",")[i].trim())));
                        i++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {

                    train = new Train(id,number,carNamber);
                    break;
                }
            }

        }

        return train;

    }
}