package main.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket  {
private long id;
private Route route;
private Type typeCar;
private int numberCar;
private int numberSeats;
private TicketStatus status;

    public Ticket(long id, Route route, Type typeCar, int numberCar, int numberSeats, TicketStatus status) {
        this.id = id;
        this.route = route;
        this.typeCar = typeCar;
        this.numberCar = numberCar;
        this.numberSeats = numberSeats;
        this.status = status;
    }

    public Ticket(Route route, Type typeCar, int numberCar, int numberSeats, TicketStatus status) {
        this.route = route;
        this.typeCar = typeCar;
        this.numberCar = numberCar;
        this.numberSeats = numberSeats;
        this.status = status;
    }

    public Ticket(long id) {
        this.id = id;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public Type getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(Type typeCar) {
        this.typeCar = typeCar;
    }

    public int getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(int numberCar) {
        this.numberCar = numberCar;
    }


    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", route=" + route +
                ", typeCar=" + typeCar +
                ", numberCar=" + numberCar +
                ", numberSeats=" + numberSeats +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId() == ticket.getId() &&
                getStatus() == ticket.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus());
    }


}






