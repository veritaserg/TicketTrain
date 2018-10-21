package main.repository;

import main.model.Car;

import java.io.IOException;
import java.util.List;

public interface CarRepository extends GenericRepository<Car,Integer> {
    @Override
    default void save(List<Car> car) throws IOException {

    }

    @Override
    void update(Car car);

    @Override
    default void delete(Integer aLong) {

    }

    @Override
    default List<Car> getAll() throws IOException {
        return null;
    }
}
