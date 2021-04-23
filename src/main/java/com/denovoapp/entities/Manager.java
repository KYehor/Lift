package com.denovoapp.entities;

import java.util.List;
import java.util.stream.Collectors;

public class Manager {

    private final Lift lift;

    public Manager(Lift lift) {
        this.lift = lift;
    }

    public void managementPassengers(){
        List<Passenger> passengersOut = lift.getPassengers().stream()
                .filter(passenger -> lift.getCurrentFloor().getNumber() == passenger.getRequiredFloor())
                .collect(Collectors.toList());
        lift.passengersOut(passengersOut);
        List<Passenger> passengersIn = lift.getCurrentFloor().getPassengers().stream()
                .filter(passenger -> lift.isLiftUp() == passenger.isPassengerUp())
                .collect(Collectors.toList());
        passengersIn.stream().limit(lift.getCapacity() - lift.getPassengers().size())
                             .forEach(passenger -> {
                                 lift.addPassenger(passenger);
                                 lift.getCurrentFloor().deletePassenger(passenger);
                             });
        lift.getCurrentFloor().addPassenger(passengersOut);
        passengersOut.forEach(passenger -> {
            passenger.setRequiredFloor(getNextFloorForPassenger(lift));
            passenger.setCurrentFloor(lift.getCurrentFloor().getNumber());
        });
    }

    public int getNextFloorForPassenger(Lift lift){
        Floor lastFloor = getLastFloor(lift.getCurrentFloor());
        return Builder.generateRandomNumber(1,lastFloor.getNumber(),lift.getCurrentFloor().getNumber());
    }

    public Floor getLastFloor(Floor floor){
        if(floor.getNext() == null){
            return floor;
        } else {
            return getLastFloor(floor.getNext());
        }
    }


}
