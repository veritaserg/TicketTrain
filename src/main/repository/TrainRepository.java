package main.repository;


import main.model.Train;
import main.model.Car;

import java.util.List;

public interface TrainRepository extends GenericRepository<Train, Long> {
    @Override
    default void save(List<Car> train) {

    }


    @Override
    default void delete(Long id) {

    }

    @Override
    default Train getById(Long id) {
        return null;
    }

    @Override
    default List<Train> getAll() {
        return null;
    }
}
