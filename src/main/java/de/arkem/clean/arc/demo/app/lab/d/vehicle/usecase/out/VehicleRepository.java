package de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vin;

public interface VehicleRepository {
    VehicleMotionData save(Vin vin, VehicleMotionData motionData);
    VehicleMotionData findVehicleMotionDataByVin(Vin vin);
}
