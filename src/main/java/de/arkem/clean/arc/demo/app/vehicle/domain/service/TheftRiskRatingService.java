package de.arkem.clean.arc.demo.app.vehicle.domain.service;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.CountryOfManufacture;

import java.util.List;

public class TheftRiskRatingService {
    public int detectRiskScore(CountryOfManufacture countryOfManufacture, List<CountryCode> riskCountries, CountryCode registrationCountry) {
        int riskScore = 0;
        boolean crossingBorder = !countryOfManufacture.value().equals(registrationCountry.value());
        boolean riskCountry = riskCountries.contains(registrationCountry);

        if (crossingBorder) {
            riskScore += 20;
        }
        if (riskCountry) {
            riskScore += 10;
        }
        if (crossingBorder && riskCountry) {
            riskScore += 30;
        }
        return riskScore;
    }
}
