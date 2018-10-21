package main.model;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Train {
    private Long id;
    private String namber;
    private List<Car> car;
    private List<Long> carNamber;

    public Train(Long id, String namber, List<Long> carNamber) {
        this.id = id;
        this.namber = namber;
        this.carNamber = carNamber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



//    public Train(String namber, List<Car> car) {
//        this.namber = namber;
//        this.car = car;
//    }




    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public String getNamber() {
        return namber;
    }

    public void setNamber(String namber) {
        this.namber = namber;
    }

    public List<Long> getCarNamber() {
        return carNamber;
    }

    public void setCarNamber(List<Long> carNamber) {
        this.carNamber = carNamber;
    }

    @Override
    public String toString() {
        return "Train{" +
                "namber='" + namber + '\'' +
                ", car=" + carNamber +
                '}';
    }
}
