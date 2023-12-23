package de.arkem.clean.arc.demo.app.lab.two.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.lab.two.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.lab.two.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.two.vehicle.domain.model.Vin;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
}
