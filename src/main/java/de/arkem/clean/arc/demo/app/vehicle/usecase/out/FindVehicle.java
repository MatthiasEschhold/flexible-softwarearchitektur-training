package de.arkem.clean.arc.demo.app.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vin;

public interface FindVehicle {
    Vehicle findByVin(Vin vin);

}
