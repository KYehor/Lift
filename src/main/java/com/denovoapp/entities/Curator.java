package com.denovoapp.entities;

import java.util.List;
import java.util.stream.Collectors;

import static com.denovoapp.entities.Builder.generateRandomNumber;

/**
 * Class Curator with properties <b>lift</b>,<b>builder</b>,<b>build</b>.
 * This class created for manage all processes in our application.
 * @author Yehor Kachur
 * @version 1.0
 */
public class Curator {

    /**Field lift. **/
    private Lift lift;
    /**Field builder. **/
    private Builder builder;
    /**Field build. **/
    private Building building;

    /**
     * We use this method to initialize instances of Builder,Build,Lift.
     */
    public void generateBuilderAndBuildingWithLift(){
        builder = new Builder();
        building = builder.generateBuild();
        lift = building.getLift();
    }

    /**
     * We use this method to manage passengers in build.
     */
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

    /**
     * We use this method to get next floor for passenger.
     */
    public int getNextFloorForPassenger(Lift lift){
        Floor lastFloor = getLastFloor(lift.getCurrentFloor());
        return generateRandomNumber(1,lastFloor.getNumber(),lift.getCurrentFloor().getNumber());
    }

    /**
     * We use this method to get last floor for passenger.
     */
    public Floor getLastFloor(Floor floor){
        if(floor.getNext() == null){
            return floor;
        } else {
            return getLastFloor(floor.getNext());
        }
    }

    public Builder getBuilder() { return builder; }

    public void setBuilder(Builder builder) { this.builder = builder; }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Lift getLift() {
        return lift;
    }

    public void setLift(Lift lift) {
        this.lift = lift;
    }
}
