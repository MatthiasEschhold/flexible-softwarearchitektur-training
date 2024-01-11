package de.arkem.clean.arc.demo.app.lab.b.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.b.vehicle.domain.model.Vehicle;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
}
