package main.repository;


import main.model.Train;
import main.model.Car;

import java.util.List;

public interface TrainRepository extends GenericRepository<Train, String> {
    @Override
    default void save(List<Car> train) {

    }


    @Override
    default void delete(String number) {

    }

    @Override
    default Train getById(String number) {
        return null;
    }

    @Override
    default List<Train> getAll() {
        return null;
    }
}
