package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.service.risk.rating;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskCountries;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskVehicleModels;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleModel;

public record RateTheftRiskCommand(LicensePlate licensePlate, VehicleModel vehicle, RegistrationCountry registrationCountry,
                                   HighRiskCountries highRiskCountries, HighRiskVehicleModels highRiskVehicleModels) {
}