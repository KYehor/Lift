package com.denovoapp.entities;

import com.denovoapp.exceptions.LiftCapacityOrNotCorrectFloorException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LiftTest {

    private Passenger passenger;
    private Set<Passenger> passengers;

    @Before
    public void setUp(){
        passenger = new Passenger(1,2);
        passengers = new HashSet<>();
    }

    @Test
    public void addFirstPassengers(){
        Lift lift = new Lift(5, new HashSet<>(), new Floor(1,new HashSet<>()),8);
        lift.addPassenger(passenger);
        Integer result = lift.getAmountPassengers();
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void addNextPassengers(){
        passengers.add(passenger);
        Lift lift = new Lift(5, passengers, new Floor(1,new HashSet<>()),8);
        Passenger secondPassenger = new Passenger(1,2);
        lift.addPassenger(secondPassenger);
        Integer result = lift.getAmountPassengers();
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test(expected = LiftCapacityOrNotCorrectFloorException.class)
    public void whenAddMoreThanCapacityOfLift(){
        passengers.add(passenger);
        Lift lift = new Lift(1, passengers, new Floor(1,new HashSet<>()),8);
        Passenger secondPassenger = new Passenger(1,2);
        lift.addPassenger(secondPassenger);

    }

    @Test(expected = LiftCapacityOrNotCorrectFloorException.class)
    public void invalidPassengerFloor(){
        passengers.add(new Passenger(1,7));
        Lift lift = new Lift(5, passengers, new Floor(2,new HashSet<>()),8);
        lift.addPassenger(passenger);
    }

    @Test
    public void willLiftUp(){
        Builder builder = new Builder();
        Building building = builder.generateBuild();
        Lift lift = building.getLift();
        int beforeLiftMove = lift.getCurrentFloor().getNumber();
        lift.moveNextFloor();
        Assertions.assertThat(beforeLiftMove+1).isEqualTo(lift.getCurrentFloor().getNumber());
    }

    @Test
    public void willLiftDown(){
        Passenger passenger = new Passenger(4,1);
        Set<Passenger> passengers = new HashSet<>();
        passengers.add(passenger);
        Builder builder = new Builder();
        List<Floor> floors = builder.generateFloor(8);
        Lift lift = new Lift(5,passengers,floors.get(3),8);
        int beforeLiftMove = lift.getCurrentFloor().getNumber();
        lift.moveNextFloor();
        Assertions.assertThat(beforeLiftMove-1).isEqualTo(lift.getCurrentFloor().getNumber());
    }



}
