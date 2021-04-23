package com.denovoapp.entities;

import java.util.List;

public class Build {

    private List<Floor> floors;
    private Lift lift;

    public Build(List<Floor> floors, Lift lift) {
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

    public void setLift(Lift lift) {
        this.lift = lift;
    }

    @Override
    public String toString() {
        return "Build{" +
                ", lift=" + lift +
                '}';
    }
}
