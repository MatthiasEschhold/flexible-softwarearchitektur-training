package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.theft.status;

public enum HighRiskVehicleModel {
    GRAND_CHEROKEE_FOURTH_GENERATION("Grand Cherokee 4.Generation"),
    STRINGER_FIRST_GENERATION("Stinger 1.Generation"),
    RANGE_ROVER_THIRD_GENERATION("Range Rover 3.Generation"),
    LAND_CRUSIER_FOURTH_GENERATION("Land Cruiser 4.Generation"),
    RANGE_ROVER_SECOND_GENERATION("Range Rover Sport 2.Generation");

    private String value;

    HighRiskVehicleModel(String value) {
        this.value = value;
    }

    public String highRiskVehicleModelValue() {
        return value;
    }
}
