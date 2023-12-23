package de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.in;


import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
}
