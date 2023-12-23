package de.arkem.clean.arc.demo.app.lab.four.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vin;

public interface VehicleRepository {
    void save(Vin vin, VehicleMotionData vehicleMotionData);
    VehicleMotionData findVehicleMotionDataByVin(Vin vin);
}
