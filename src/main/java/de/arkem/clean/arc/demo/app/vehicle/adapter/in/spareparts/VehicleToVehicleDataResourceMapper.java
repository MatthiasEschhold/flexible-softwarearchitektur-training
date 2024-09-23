package de.arkem.clean.arc.demo.app.vehicle.adapter.in.spareparts;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.Mileage;

public class VehicleToVehicleDataResourceMapper {
    public VehicleDataResource mapVehicleToResource(Vehicle vehicle) {
        VehicleDataResource vehicleDataResource = new VehicleDataResource();
        vehicleDataResource.setVin(vehicle.getVin().value());
        vehicleDataResource.setLicensePlate(vehicle.getLicensePlate().value());
        vehicleDataResource.setMileage(vehicle.findLatestMileage().map(Mileage::value).orElse(0.0));
        return vehicleDataResource;
    }
}
