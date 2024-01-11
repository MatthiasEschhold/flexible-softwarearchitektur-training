package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.service.risk.rating;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.VehicleModel;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.LicensePlate;

public class RateTheftRiskCommandFactory {

    public RateTheftRiskCommand create(LicensePlate licensePlate, VehicleModel vehicleModel, RegistrationCountry registrationCountry) {
        return new RateTheftRiskCommand(licensePlate, vehicleModel, registrationCountry);
    }
}
