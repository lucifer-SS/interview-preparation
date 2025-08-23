package com.design.elevator;

public class FloorButton implements Button {

    private Integer floorNumber;

    public FloorButton(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public void onPress() {
        // ToDo: Action to be performed
    }

    @Override
    public boolean isPressed() {
        return false;
    }
}
