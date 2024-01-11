package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data;

public record VehicleModel(String value) {
    public VehicleModel {
        validateVehicleModel(value);
    }

    private void validateVehicleModel(String value) {
        if (!isValidVehicleModel(value)) {
            throw new IllegalStateException("equipment label is not valid");
        }
    }

    private boolean isValidVehicleModel(String value) {
        return value != null && !value.isBlank();
    }
}