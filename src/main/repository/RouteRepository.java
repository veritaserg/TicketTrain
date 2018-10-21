package main.repository;


import main.model.Car;
import main.model.Route;

import java.util.List;

public interface RouteRepository extends GenericRepository<Route,Long> {
    @Override
    default void save(List<Car> route) {

    }

    @Override
    default void delete(Long aLong) {

    }

    @Override
    default List<Route> getAll() {
        return null;
    }
}
