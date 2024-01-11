package de.arkem.clean.arc.demo.app.lab.f.vehicle.usecase.in;


import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
    Vehicle updateMileage(Vin vin, Mileage mileage);
}
