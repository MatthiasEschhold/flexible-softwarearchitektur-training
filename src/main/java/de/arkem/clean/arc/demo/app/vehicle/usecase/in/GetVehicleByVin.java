package de.arkem.clean.arc.demo.app.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vin;

public interface GetVehicleByVin {
    Vehicle get(Vin vin);

}
