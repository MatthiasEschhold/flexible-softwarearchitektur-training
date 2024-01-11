package de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vin;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
}
