package com.denovoapp.entities;

public class Main {
    public static void main(String[] args) {
        Builder builder = new Builder();
        Build build = builder.generateBuild();
        Manager manager = new Manager(build.getLift());
        manager.managementPassengers();
        while(true){
            build.getLift().moveNextFloor();
            manager.managementPassengers();
            System.out.println(build.toString());
        }

    }
}
