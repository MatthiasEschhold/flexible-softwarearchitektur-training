package de.arkem.clean.arc.demo.app.lab.two.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.two.vehicle.domain.model.Vehicle;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
}
