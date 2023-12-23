package de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle;

public interface FetchVehicleByLicensePlate {
    Vehicle fetchByLicensePlate(LicensePlate licensePlate);
}
