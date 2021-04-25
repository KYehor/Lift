package com.denovoapp.entities;

import java.util.*;

/**
 * Class Builder with properties <b>MAX_FLOOR</b>,<b>MIN_FLOOR</b>,<b>MAX_PASSENGERS</b>
 * ,<b>MIN_PASSENGERS</b>,<b>LIFT_CAPACITY</b>.
 * This class create our building with floors and passengers inside.
 * @author Yehor Kachur
 * @version 1.0
 */
public class Builder {

    private static final int MAX_FLOOR = 20;
    private static final int MIN_FLOOR = 5;
    private static final int MAX_PASSENGERS = 10;
    private static final int MIN_PASSENGERS = 0;
    private static final int LIFT_CAPACITY = 5;

    /**
     * This method is for generate random number between two numbers
     * ,we need it to create random floors.
     * @param min;
     * @param max;
     **/
    public static int generateRandomNumber(int min,int max){
        Random random = new Random();
        return random.nextInt(max-min)+min;
    }
    /**
     * This method is for generate random number between two numbers
     * ,we need it to create random number passengers on floors.
     * @param min;
     * @param max;
     * @param notAble;
     **/
    public static int generateRandomNumber(int min,int max,int notAble){
        int result = generateRandomNumber(min,max);
        if(result != notAble){
            return result;
        }else{
            return generateRandomNumber(min,max,notAble);
        }
    }

    /**
     * This method generate instances of Passenger.
     * @param floorNumber;
     * @param amountOfFloor;
     **/
    public Set<Passenger> generatePassenger(int floorNumber,int amountOfFloor){
        Set<Passenger> passengers = new HashSet<>();
        int result = generateRandomNumber(MIN_PASSENGERS, MAX_PASSENGERS);
        for(int count = 0;count < result; count++){
            int requiredFloor = generateRandomNumber(2,amountOfFloor,floorNumber);
            passengers.add(new Passenger(floorNumber,requiredFloor));
        }
        return passengers;
    }

    /**
     * This method created to realize LinkedList methodology.
     * @param floors;
     **/
    public void linkFloor(List<Floor> floors){
        if(floors.size() > 2){
            Floor nextFloor = floors.get(floors.size() - 1);
            Floor currentFloor = floors.get(floors.size() - 2);
            Floor previousFloor = floors.get(floors.size() - 3);
            currentFloor.setNext(nextFloor);
            currentFloor.setPrevious(previousFloor);
        }else if(floors.size() == 2){
            Floor currentFloor = floors.get(1);
            Floor previousFloor = floors.get(0);
            previousFloor.setNext(currentFloor);
        }
    }

    /**
     * This method generate floors of building.
     * @param amountOfFloor;
     **/
    public List<Floor> generateFloor(int amountOfFloor) {
        List<Floor> floors = new ArrayList<>();
        for(int count = 0;count < amountOfFloor;count++){
            Set<Passenger> passengers = generatePassenger(count+1, amountOfFloor);
            floors.add(new Floor(count+1,passengers));
            linkFloor(floors);
        }
        return floors;
    }

    /**
     * This method generate build.
     **/
    public Building generateBuild(){
        int result = generateRandomNumber(MIN_FLOOR,MAX_FLOOR);
        List<Floor> floors = generateFloor(result);
        return new Building(floors,new Lift(LIFT_CAPACITY,new HashSet<>(),floors.get(0),result));
    }

}
