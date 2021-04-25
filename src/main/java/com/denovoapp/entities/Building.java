package com.denovoapp.entities;

import java.util.List;

/**
 * Class Building with properties <b>floors</b>,<b>lift</b>.
 *
 * @author Yehor Kachur
 * @version 1.0
 */
public class Building {

    private List<Floor> floors;
    private Lift lift;

    /**
     * Constructor - Building
     * @param floors - Building list of floors
     * @param lift - Building lift
     */
    public Building(List<Floor> floors, Lift lift) {
        this.floors = floors;
        this.lift = lift;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public Lift getLift() {
        return lift;
    }

    public void setLift(Lift lift) { this.lift = lift; }

    @Override
    public String toString() {
        return "Build{" +
                ", lift=" + lift +
                '}';
    }

}
