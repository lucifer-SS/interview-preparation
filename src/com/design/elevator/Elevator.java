package com.design.elevator;

import java.util.*;

public class Elevator {
    private Integer elevatorNumber;
    private ElevatorState elevatorState;
    private ElevatorDoor elevatorDoor;
    private List<FloorButton> floorButtons;
    private List<DoorButton> doorButtons;

    private Queue<Integer> currentStops;
    private Map<Direction, Queue<Integer>> stops;

    public Elevator (Integer elevatorNumber, Integer numberOfFloors) {
        this.elevatorNumber = elevatorNumber;
        this.elevatorState = new ElevatorState(elevatorNumber);
        this.elevatorDoor = new ElevatorDoor(DoorStatus.OPEN, this.elevatorState);

        floorButtons = new LinkedList<>();
        for (int floorNumber = 0; floorNumber < numberOfFloors; floorNumber++) {
            floorButtons.add(new FloorButton(floorNumber));
        }

        doorButtons = new LinkedList<>();
        doorButtons.add(new DoorButton(this.elevatorDoor, DoorStatus.OPEN));
        doorButtons.add(new DoorButton(this.elevatorDoor, DoorStatus.ClOSED));

        stops = new HashMap<>();
        stops.put(Direction.UP, new PriorityQueue<>());
        stops.put(Direction.DOWN, new PriorityQueue<>());
    }

    public void assignFloor(DirectionButton request) {
        if (elevatorState.getDirection() == request.getDirection()) {
            // ToDo: Compare with peek() of current queue
        } else {
            stops.get(request.getDirection()).offer(request.getFloorNumber());
        }
    }

    public ElevatorState getElevatorState() {
        return this.elevatorState;
    }

    // ToDo: Read about Synchronized Blocks to implement the Continuous movement of Elevator.

}
