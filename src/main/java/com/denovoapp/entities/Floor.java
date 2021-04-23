package com.denovoapp.entities;

import java.util.List;
import java.util.Set;

public class Floor {

    private Set<Passenger> passengers;
    private int number;

    private Floor next;
    private Floor previous;

    public Floor(int number, Set<Passenger> passengers) {
        this.number = number;
        this.passengers = passengers;
    }


    public void addPassenger(Passenger passenger){
        passengers.add(passenger);
    }

    public void deletePassenger(Passenger passenger){
        passengers.remove(passenger);
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Floor getNext() {
        return next;
    }

    public void setNext(Floor next) {
        this.next = next;
    }

    public Floor getPrevious() {
        return previous;
    }

    public void setPrevious(Floor previous) {
        this.previous = previous;
    }

    public void addPassenger(List<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    @Override
    public String toString() {
        return "Floor{" +
                "passengers=" + passengers +
                ", number=" + number +
                '}';
    }
}
