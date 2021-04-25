package com.denovoapp.entities;

import java.util.List;
import java.util.Set;

/**
 * Class Floor with properties <b>passengers</b>,<b>number</b>,<b>next</b>,<b>previous</b>.
 *
 * @author Yehor Kachur
 * @version 1.0
 */
public class Floor {

    /**Field currentFloor, floor of build, where passenger wait lift. **/
    private Set<Passenger> passengers;
    /**Field number, floor have own number. **/
    private int number;

    /**Field next, created to have own realization LinkedList. **/
    private Floor next;
    /**Field previous, created to have own realization LinkedList. **/
    private Floor previous;

    /**
     * Constructor - Passenger
     * @param number - Passenger current floor
     * @param passengers - List of passengers on the floor
     */
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
