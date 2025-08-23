package com.design.elevator;

public class ElevatorState { // This will be used to power display unit.
    private Integer elevatorNumber;

    private Direction direction;
    private Integer floorNumber;
    private Boolean inMotion;

    public ElevatorState(Integer elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
        this.direction = Direction.IDLE;
        this.inMotion = false;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Boolean getInMotion() {
        return inMotion;
    }

    public void setInMotion(Boolean inMotion) {
        this.inMotion = inMotion;
    }
}
