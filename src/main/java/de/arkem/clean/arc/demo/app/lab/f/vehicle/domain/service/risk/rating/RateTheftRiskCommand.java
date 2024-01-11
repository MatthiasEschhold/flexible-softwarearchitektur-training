package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.service.risk.rating;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskCountries;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskVehicleModels;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.master.data.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.master.data.VehicleModel;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.LicensePlate;

public record RateTheftRiskCommand(LicensePlate licensePlate, VehicleModel vehicle, RegistrationCountry registrationCountry,
                                   HighRiskCountries highRiskCountries, HighRiskVehicleModels highRiskVehicleModels) {
}