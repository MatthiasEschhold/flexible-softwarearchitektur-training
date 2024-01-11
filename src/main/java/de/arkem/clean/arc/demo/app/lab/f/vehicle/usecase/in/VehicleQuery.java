package de.arkem.clean.arc.demo.app.lab.f.vehicle.usecase.in;


import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vin;

public interface VehicleQuery {
    Vehicle findByVin(Vin vin);
}
