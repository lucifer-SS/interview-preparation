package com.design.elevator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FloorPanel {

    private Integer floorNumber;
    private ElevatorManager elevatorManager;
    private List<DirectionButton> requestButtons;

    public FloorPanel(Integer floorNumber, ElevatorManager elevatorManager) {
        this.floorNumber = floorNumber;
        this.elevatorManager = elevatorManager;

        // Create UP and DOWN request buttons
        this.requestButtons = new LinkedList<DirectionButton>();
        requestButtons.add(new DirectionButton(floorNumber, Direction.UP, elevatorManager));
        requestButtons.add(new DirectionButton(floorNumber, Direction.DOWN, elevatorManager));
    }

    // This function is used to display Elevator Information on each floor.
    public List<ElevatorState> getElevatorStates() {
        return elevatorManager.getElevators().stream()
                .map( elevator -> elevator.getElevatorState())
                .collect(Collectors.toList());
    }

    public List<DirectionButton> getRequestButtons() {
        return requestButtons;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }
}
