package de.arkem.clean.arc.demo.app.lab.d.vehicle.adapter.out.db.vehicle;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vin;

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
