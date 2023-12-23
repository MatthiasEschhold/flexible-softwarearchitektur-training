package de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.service;

import de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.HighRiskCountry;

import java.util.List;

public class TheftRiskRatingService {
    private static final String GERMAN_COUNTRY_CODE = "DE-de";
    private static final String FRANCE_COUNTRY_CODE = "FR-fr";

    public Integer rateTheftRisk(LicensePlate licensePlate, List<HighRiskCountry> highRiskCountries) {
        Integer riskScore = 0;
        String countryCodeOfLicensePlate = detectCountryCodeOfLicensePlate(licensePlate);
        if(!licensePlate.isEuLicensePlate()) {
            riskScore = riskScore + 20;
            if(highRiskCountries.contains(countryCodeOfLicensePlate)) {
                riskScore = riskScore + 30;
            }
        } else {
            if(!licensePlate.isGermanLicensePlate()) {
                riskScore = riskScore + 20;
                if(highRiskCountries.contains(countryCodeOfLicensePlate)) {
                    riskScore = riskScore + 15;
                }
            }
        }
        return riskScore;
    }

    private String detectCountryCodeOfLicensePlate(LicensePlate licensePlate) {
        if (licensePlate.value().matches(LicensePlate.GERMAN_LICENSE_PLATE_PATTERN)) {
            return "DE-de";
        } else if (licensePlate.value().matches(LicensePlate.FRANCE_LICENSE_PLATE_PATTERN)) {
            return "FR-fr";
        } //... and many more
        return "";
    }

}
