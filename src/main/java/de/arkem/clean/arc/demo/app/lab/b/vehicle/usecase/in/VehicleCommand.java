package de.arkem.clean.arc.demo.app.lab.b.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.lab.b.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.lab.b.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.b.vehicle.domain.model.Vin;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
}
