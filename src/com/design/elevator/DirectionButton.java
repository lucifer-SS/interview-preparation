package com.design.elevator;

public class DirectionButton implements Button {

    private Integer floorNumber;
    private Direction direction;

    // Observer
    private ElevatorManager elevatorManager;

    public DirectionButton(Integer floorNumber, Direction direction, ElevatorManager elevatorManager) {
        this.floorNumber = floorNumber;
        this.direction = direction;
        this.elevatorManager = elevatorManager;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public void onPress() {
        // ToDo: Action
    }

    @Override
    public boolean isPressed() {
        return false;
    }
}
