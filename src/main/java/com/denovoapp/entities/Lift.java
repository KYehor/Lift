package com.denovoapp.entities;

import java.util.List;
import java.util.Set;

public class Lift {

    private final Integer capacity;
    private final Set<Passenger> passengers;
    private Floor currentFloor;
    private int maxFloor;


    public Lift(Integer capacity, Set<Passenger> passengers, Floor currentFloor, int maxFloor) {
        this.capacity = capacity;
        this.passengers = passengers;
        this.currentFloor = currentFloor;
        this.maxFloor = maxFloor;
    }

    public void addPassenger(Passenger passenger) {
        if(capacity > passengers.size() && passenger.getCurrentFloor() == currentFloor.getNumber()){
            passengers.add(passenger);
        }else{
            throw new RuntimeException();
        }
    }

    public Integer getAmountPassengers() {
        return passengers.size();
    }

    public boolean isLiftUp(){
        return passengers.stream()
                .map(p -> p.getCurrentFloor() < p.getRequiredFloor())
                .findFirst()
                .orElse(this.currentFloor.getPassengers().stream()
                        .map(p -> p.getCurrentFloor() < p.getRequiredFloor())
                        .findFirst()
                .orElse(this.currentFloor.getNumber() == 1));
    }

    public void moveNextFloor() {
        if (isLiftUp()) {
            currentFloor = currentFloor.getNext();
        } else {
            currentFloor = currentFloor.getPrevious();
        }
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public Floor getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(Floor currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void passengersOut(List<Passenger> passengersOut) {
        passengers.removeAll(passengersOut);
    }

    @Override
    public String toString() {
        return "Lift{" +
                "capacity=" + capacity +
                ", passengers=" + passengers +
                ", currentFloor=" + currentFloor +
                ", maxFloor=" + maxFloor +
                '}';
    }
}
