package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.db.VehicleDbEntity;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;

public class VehicleToDbEntityDbMapper {
    public VehicleDbEntity mapVehicleToDbEntity(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vin.value());
        vehicleDbEntity.setLicensePlate(vehicleMotionData.licensePlate().value());
        return vehicleDbEntity;
    }
}
