package de.arkem.clean.arc.demo.app.lab.c.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vin;

public class VehicleToDbEntityDbMapper {
    public VehicleDbEntity mapVehicleToDbEntity(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vin.value());
        vehicleDbEntity.setLicensePlate(vehicleMotionData.licensePlate().value());
        return vehicleDbEntity;
    }

    public VehicleMotionData mapVehicleDbEntityToVehicleMotionData(VehicleDbEntity vehicle) {
        return new VehicleMotionData(new LicensePlate(vehicle.getLicensePlate()));
    }
}
