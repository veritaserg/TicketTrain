package main.repository.io;



import main.model.Car;
import main.repository.CarRepository;
import main.repository.builder.Builder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class JavaIOCarImpl implements CarRepository {
    static String pathCar = "C:\\Users\\server\\IdeaProjects\\ templates\\com\\sergeev\\TrainTicket\\src\\main\\resource\\car.csv";


    public void save(List<Car> cars) throws IOException {
        Path paths = Paths.get(pathCar);
        FileWriter fileWriter = new FileWriter(String.valueOf(paths));
        fileWriter.write("");
        fileWriter.close();

        for (Car car : cars) {
            String carString = car.getId() + "," + car.getType() + ", " + carSeat(car) + "\n";
            Files.write(paths, carString.getBytes(), StandardOpenOption.APPEND);
        }
    }

    @Override
    public void update(Car car) {

    }

    @Override
    public void create(Car car) {

    }

    @Override
    public Car getById(Integer integer) {
        return null;
    }

    @Override
    public List<Car> getAll() throws IOException {
        return Builder.getCars();

    }

    public static String carSeat(Car car) {
        String seat = String.valueOf(car.getSeatAll());
        seat = seat.substring(1, seat.length() - 1);
        return seat;
    }
}