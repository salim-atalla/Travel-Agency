package fr.unantes.sce.calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Correspondence {
    private Travel travel;
    private City originCity;
    private City destinationCity;
    private LocalDateTime startTime;
    private LocalDateTime arrivalTime;

    public Correspondence(Travel travel, City originCity, City destinationCity, LocalDateTime startTime, LocalDateTime arrivalTime) {
        this.setTravel(travel);
        this.setOriginCity(originCity);
        this.setDestinationCity(destinationCity);
        this.setStartTime(startTime);
        this.setArrivalTime(arrivalTime);
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        if (travel != null) {
            travel.basicRemoveCorrespondence(this);
        }
        this.basicSetTravel(travel);
            assert travel != null;
            if (!travel.steps().contains(this)) {
                     travel.basicAddCorrespondence(this);
                }

    }

    public void basicSetTravel (Travel travel) { this.travel = travel; }

    public void unSetTravel () {
        this.travel.basicRemoveCorrespondence(this);
        this.basicUnSetTravel();
    }

    private void basicUnSetTravel () {
        this.travel = null;
    }

    public City getOriginCity() {
        return originCity;
    }

    public void setOriginCity(City originCity) {
        this.originCity = originCity;
    }

    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correspondence that = (Correspondence) o;
        return getOriginCity().equals(that.getOriginCity()) &&
                getDestinationCity().equals(that.getDestinationCity()) &&
                getStartTime() == that.getStartTime() &&
                getArrivalTime() == that.getArrivalTime();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTravel(), getOriginCity(), getDestinationCity(), getStartTime(), getArrivalTime());
    }
}
