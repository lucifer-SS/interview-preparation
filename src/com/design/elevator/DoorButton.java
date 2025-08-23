package com.design.elevator;

public class DoorButton implements Button {

    private ElevatorDoor elevatorDoor; // Observing the button
    private DoorStatus action;
    private Boolean isPressed;

    public DoorButton(ElevatorDoor elevatorDoor, DoorStatus action) {
        this.elevatorDoor = elevatorDoor;
        this.action = action;
        this.isPressed = false;
    }

    @Override
    public void onPress() {
        setIsPressed(true);
        elevatorDoor.setDoorStatus(action);
        setIsPressed(false);
    }

    @Override
    public boolean isPressed() {
        return this.isPressed;
    }

    private void setIsPressed(Boolean isPressed) {
        this.isPressed = isPressed;
    }
}
