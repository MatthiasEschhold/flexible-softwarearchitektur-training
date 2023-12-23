package de.arkem.clean.arc.demo.app.lab.five.garage.order.usecase.out;

import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.Vehicle;

public interface FetchVehicle {
    Vehicle fetch(LicensePlate licensePlate);
}
