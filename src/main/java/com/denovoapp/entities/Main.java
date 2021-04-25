package com.denovoapp.entities;

public class Main {

    public static void main(String[] args) {
        Curator curator = new Curator(); //Create our curator
        curator.generateBuilderAndBuildingWithLift(); //generate Builder, Building and Lift
        curator.managementPassengers(); // start manage passengers in build
        System.out.println(curator.getBuilding().toString()); //show information about first floor
        while(true){
            curator.getLift().moveNextFloor(); // move our lift further
            curator.managementPassengers(); // managing our passengers on the floor and inside lift
            System.out.println(curator.getBuilding().toString()); // show next floor
        }
    }

}
