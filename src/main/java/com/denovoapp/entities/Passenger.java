package com.denovoapp.entities;

public class Passenger {

    private int currentFloor;
    private int requiredFloor;

    public
    Passenger(int currentFloor, int requiredFloor) {
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
