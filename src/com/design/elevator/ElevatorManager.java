package com.design.elevator;

import java.util.LinkedList;
import java.util.List;

public class ElevatorManager {

    private List<FloorPanel> floorPanels;
    private List<Elevator> elevators;

    private ElevatorManager() { }

    // ToDo: Make all interactive functions thread safe and synchronised.

    public static ElevatorManager initiate(Integer numberOfElevators, Integer numberOfFloors) {
        ElevatorManager elevatorManager = new ElevatorManager();
        elevatorManager.initiateElevators(numberOfElevators, numberOfFloors);
        elevatorManager.initiateFloorPanels(numberOfFloors);

        return elevatorManager;
    }

    public List<FloorPanel> getFloorPanels() {
        return this.floorPanels;
    }

    public List<Elevator> getElevators() {
        return this.elevators;
    }

    public Elevator assignElevator(DirectionButton reqeust) {
        // ToDo: Actual Implementation Logic
        return null;
    }

    private void initiateElevators(Integer numberOfElevators, Integer numberOfFloors) {
        this.elevators = new LinkedList<Elevator>();
        for (int elevatorNumber = 1; elevatorNumber <= numberOfElevators; elevatorNumber++) {
            this.elevators.add(new Elevator(elevatorNumber, numberOfFloors));
        }
    }

    private void initiateFloorPanels(Integer numberOfFloors) {
        this.floorPanels = new LinkedList<FloorPanel>();
        for (int floorNumber = 0; floorNumber <= numberOfFloors; floorNumber++) {
            this.floorPanels.add(new FloorPanel(floorNumber, this));
        }
    }

}
