package de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.dto.VehicleQueryResult;

public interface VehicleRepository {
    void save(Vin vin, VehicleMotionData vehicleMotionData);

    VehicleMotionData findVehicleMotionDataByVin(Vin vin);

    VehicleQueryResult findVehicleMotionDataByLicensePlate(LicensePlate licensePlate);

}
