package com.denovoapp.entities;

/**
 * Class Passenger with properties <b>currentFloor</b>,<b>requiredFloor</b>.
 *
 * @author Yehor Kachur
 * @version 1.0
 */
public class Passenger {

    /**Field currentFloor, floor of build, where passenger wait lift. **/
    private int currentFloor;

    /**Field requiredFloor, floor of build on which passenger need take the lift. **/
    private int requiredFloor;

    /**
     * Constructor - Passenger
     * @param currentFloor - Passenger current floor
     * @param requiredFloor - Passenger required floor
     */
    public Passenger(int currentFloor, int requiredFloor) {
        this.currentFloor = currentFloor;
        this.requiredFloor = requiredFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean isPassengerUp(){
        return currentFloor < requiredFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getRequiredFloor() {
        return requiredFloor;
    }

    public void setRequiredFloor(int requiredFloor) {
        this.requiredFloor = requiredFloor;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "currentFloor=" + currentFloor +
                ", requiredFloor=" + requiredFloor +
                '}';
    }
}
