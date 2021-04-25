package com.denovoapp.entities;

import com.denovoapp.exceptions.LiftCapacityOrNotCorrectFloorException;

import java.util.List;
import java.util.Set;

/**
 * Class Lift with properties <b>capacity</b>, <b>passengers</b>, <b>currentFloor</b>, <b>maxFloor</b>.
 *
 * @author Yehor Kachur
 * @version 1.0
 */
public class Lift {

    /**Field capacity, capacity of passengers in lift **/
    private final Integer capacity;
    /**Field passengers, list of passengers in Lift. **/
    private final Set<Passenger> passengers;
    /**Field currentFloor, current floor of lift. **/
    private Floor currentFloor;
    /**Field maxFloor, max floor of build. **/
    private int maxFloor;

    /**
     * Constructor - Lift
     * @param capacity - Lift capacity of passengers
     * @param passengers - Lift list of passengers
     * @param currentFloor - Lift current floor
     * @param maxFloor - Lift max floor of build
     */
    public Lift(Integer capacity, Set<Passenger> passengers, Floor currentFloor, int maxFloor) {
        this.capacity = capacity;
        this.passengers = passengers;
        this.currentFloor = currentFloor;
        this.maxFloor = maxFloor;
    }

    /**
     * We use this method to add new passenger in lift.
     * @param  passenger - instance of Passenger class
     */
    public void addPassenger(Passenger passenger) {
        if(capacity > passengers.size() && passenger.getCurrentFloor() == currentFloor.getNumber()){
            passengers.add(passenger);
        }else{
            throw new LiftCapacityOrNotCorrectFloorException("Can't add new passenger in lift,capacity of Lift is 5 passengers." +
                    " Lift and passenger current floor is not the same");
        }
    }

    public Integer getAmountPassengers() {
        return passengers.size();
    }

    /**
     * This method check what will do our lift move up or down.
     */
    public boolean isLiftUp(){
        return passengers.stream()
                .map(p -> p.getCurrentFloor() < p.getRequiredFloor())
                .findFirst()
                .orElse(this.currentFloor.getPassengers().stream()
                        .map(p -> p.getCurrentFloor() < p.getRequiredFloor())
                        .findFirst()
                .orElse(this.currentFloor.getNumber() == 1));
    }

    /**
     * This method move our lift on the floor that need passenger.
     */
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

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
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
