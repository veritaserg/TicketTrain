package main.model;

import java.time.LocalDateTime;

import java.util.Map;
import java.util.Objects;

public class Route {
    private Long id;
    private Map<Location,LocalDateTime> locations;
    private String numberTrain;


    public Route(Long id, Map<Location, LocalDateTime> locations, String numberTrain) {
        this.id = id;
        this.locations = locations;
        this.numberTrain = numberTrain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberTrain() {
        return numberTrain;
    }

    public void setNumberTrain(String numberTrain) {
        this.numberTrain = numberTrain;
    }

    public Map<Location, LocalDateTime> getLocations() {
        return locations;
    }

    public void setLocations(Map<Location, LocalDateTime> locations) {
        this.locations = locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Route)) return false;
        Route route = (Route) o;
        return Objects.equals(getLocations(), route.getLocations());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLocations());
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", locations=" + locations +
                ", numberTrain='" + numberTrain + '\'' +
                '}';
    }
}
