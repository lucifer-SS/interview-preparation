package com.design.elevator;

public class ElevatorDoor {
    private DoorStatus doorStatus;
    private ElevatorState elevatorState;

    public ElevatorDoor (DoorStatus startingStatus, ElevatorState elevatorState) {
        this.doorStatus = startingStatus;
        this.elevatorState = elevatorState;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public void setDoorStatus(DoorStatus doorStatus) {
        if (!elevatorState.getInMotion()) {
            // ToDo: Initiate Door Operation
            this.doorStatus = doorStatus;
        }
    }
}
