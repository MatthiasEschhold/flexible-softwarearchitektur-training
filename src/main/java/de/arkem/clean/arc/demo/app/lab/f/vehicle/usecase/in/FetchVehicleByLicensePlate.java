package de.arkem.clean.arc.demo.app.lab.f.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vehicle;

public interface FetchVehicleByLicensePlate {
    Vehicle fetchByLicensePlate(LicensePlate licensePlate);
}
