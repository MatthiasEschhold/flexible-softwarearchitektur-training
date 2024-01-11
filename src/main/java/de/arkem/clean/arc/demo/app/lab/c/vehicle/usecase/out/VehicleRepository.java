package de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vin;

public interface VehicleRepository {
    VehicleMotionData save(Vin vin, VehicleMotionData vehicleMotionData);
}
