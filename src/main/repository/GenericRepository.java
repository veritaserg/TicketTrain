package main.repository;


import main.model.Car;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T,ID> {
    void create(T t);
    void save(List<Car> car) throws IOException;

    void update(T t) throws IOException;

    void delete(ID id);

    T getById(ID id) ;

    List<T> getAll() throws IOException;


}
