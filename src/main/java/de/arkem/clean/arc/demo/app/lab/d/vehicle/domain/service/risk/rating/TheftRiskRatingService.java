package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.service.risk.rating;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.CountryCode;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskVehicleModels;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleModel;

import java.util.List;
import java.util.stream.Collectors;

public class TheftRiskRatingService {

    public Integer rateTheftRisk(LicensePlate licensePlate, VehicleModel vehicleModel, RegistrationCountry registrationCountry) {
        Integer riskScore = 0;
        CountryCode countryCode = detectCountryCodeOfLicensePlate(licensePlate);
        riskScore += rateRiskForCrossingBorders(registrationCountry, countryCode);
        riskScore += rateRiskForNonEuropeanCountry(licensePlate);
        return riskScore;
    }

    private Integer rateRiskForNonEuropeanCountry(LicensePlate licensePlate) {
        if (licensePlate.isEuropeanLicensePlate()) {
            return 0;
        }
        return 10;
    }

    private List<String> mapToHighRiskVehicleModelValues(HighRiskVehicleModels highRiskVehicleModels) {
        return highRiskVehicleModels.values()
                .stream()
                .map(m -> m.highRiskVehicleModelValue())
                .collect(Collectors.toList());
    }

    private Integer rateRiskForCrossingBorders(RegistrationCountry registrationCountry, CountryCode countryCode) {
        if (!registrationCountry.value().equals(countryCode.countryCodeValue())) {
            return 30;
        }
        return 0;
    }

    private CountryCode detectCountryCodeOfLicensePlate(LicensePlate licensePlate) {
        if (licensePlate.isGermanyLicensePlate()) {
            return CountryCode.DE;
        } else if (licensePlate.isFranceLicensePlate()) {
            return CountryCode.FR;
        } else if (licensePlate.isItalianLicensePlate()) {
            return CountryCode.IT;
        } else if (licensePlate.isSpainLicensePlate()) {
            return CountryCode.ESP;
        } else if (licensePlate.isGreatBritianLicensePlate()) {
            return CountryCode.GB;
        } else if(licensePlate.isBrazilLicensePlate()) {
            return CountryCode.BZ;
        } else if(licensePlate.isMexicoLicensePlate()) {
            return CountryCode.MEX;
        } else if(licensePlate.isUsaLicensePlate()) {
            return CountryCode.USA;
        } else if(licensePlate.isRussiaLicensePlate()) {
            return CountryCode.RU;
        } else if(licensePlate.isSaudiArabiaLicensePlate()) {
            return CountryCode.SA;
        }else {
            return CountryCode.NOT_RELEVANT;
        }
    }

}
