package de.arkem.clean.arc.demo.app.lab.f.garage.order.adapter.out.vehicle;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.Vehicle;

public class VehicleToOriginVehicleMapper {

    Vehicle mapOriginVehicleToVehicle(Vehicle vehicle) {
        return new Vehicle(new LicensePlate(vehicle.getVehicleMotionData().licensePlate().value()),
                vehicle.getVehicleMotionData().mileage().mileageValue().value());
    }
}
