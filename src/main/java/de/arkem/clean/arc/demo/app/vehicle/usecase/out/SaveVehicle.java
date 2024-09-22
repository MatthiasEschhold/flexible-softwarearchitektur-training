package de.arkem.clean.arc.demo.app.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vehicle;

public interface SaveVehicle {
    Vehicle save(Vehicle vehicle);
}
