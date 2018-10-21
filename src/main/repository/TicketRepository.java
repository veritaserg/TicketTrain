package main.repository;


import main.model.Car;
import main.model.Ticket;

import java.io.IOException;
import java.util.List;

public interface TicketRepository extends GenericRepository<Ticket,Long> {
    @Override
    void create(Ticket ticket);

    @Override
    default void save(List<Car> ticket) {

    }

    @Override
    void update(Ticket ticket) throws IOException;

    @Override
    default void delete(Long aLong) {

    }


    @Override
    default List<Ticket> getAll() {
        return null;
    }
}
