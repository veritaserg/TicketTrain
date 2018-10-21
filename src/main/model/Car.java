package main.model;

import java.util.*;

public class Car {
    private Long id;
     private Type type;
    private Status status = Status.OPEN;
    private Map<Integer, Status> seats = new HashMap<>();

    public Car(Long id, Type type, Map<Integer, Status> seats) {
       this.id = id;
        this.type = type;
        this.seats = seats;
    }

    public Car(Long id, Type type, Integer numberSeats) {
        this.id = id;
        this.type = type;
        for (int i = 1; i <= numberSeats; i++) {
            seats.put(i, status);
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getSeatsStatusOpen(){
        List<Integer> statusOpen = new ArrayList<>();
     for (Map.Entry<Integer,Status> pair : seats.entrySet()){
         if (pair.getValue().equals(Status.OPEN)){
             statusOpen.add(pair.getKey());
         }
     }
       return statusOpen;

    }
    public List<String> getSeatAll(){
        List<String> seatAll = new ArrayList<>();
        for (Map.Entry<Integer,Status> pair : seats.entrySet()){
            String seat = pair.getKey()+"," + pair.getValue();
            seatAll.add(seat);
        }
        return seatAll;
    }

    public void setSeats(Map<Integer, Status> seats) {
        this.seats = seats;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Map<Integer, Status> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return type+" " + seats+
                "";
    }

}
