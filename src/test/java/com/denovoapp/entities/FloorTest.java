package com.denovoapp.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FloorTest {

    private Passenger passenger;
    private Set<Passenger> passengers;
    private Floor floor;

    @Before
    public void setUp(){
        passenger = new Passenger(1,3);
        passengers = new HashSet<>();
        floor = new Floor(1,passengers);
    }

    @Test
    public void addNewPassenger(){
        floor.addPassenger(passenger);
        assertThat(floor.getPassengers().size()).isEqualTo(1);
    }

    @Test
    public void removePassenger(){
        Passenger secondPassenger = new Passenger(1,4);
        floor.addPassenger(secondPassenger);
        floor.deletePassenger(secondPassenger);
        assertThat(floor.getPassengers().size()).isEqualTo(0);
    }
}
