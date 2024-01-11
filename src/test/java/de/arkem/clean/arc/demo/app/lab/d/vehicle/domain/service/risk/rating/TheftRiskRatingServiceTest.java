package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.service.risk.rating;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.*;
import de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.*;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleModel;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TheftRiskRatingServiceTest {
    @Test
    void shouldRateRiskWithMatchForVehicleModelAndRiskCountryEu() {
        RateTheftRiskCommand command = createRateTheftRiskCommand(
                "ES-EL 0815", //ok
                HighRiskVehicleModel.GRAND_CHEROKEE_FOURTH_GENERATION.highRiskVehicleModelValue(), //match high risk model
                "DE" //ok
        );

        TheftRiskRatingService theftRiskRatingService = new TheftRiskRatingService();
        Integer result = theftRiskRatingService.rateTheftRisk(command);
        assertThat(result, is(10));
    }

    @Test
    void shouldRateRiskWithMatchForRiskCountryNonEu() {
        RateTheftRiskCommand command = createRateTheftRiskCommand(
                "US 25 LO", //match USA as non EU high risk country
                HighRiskVehicleModel.LAND_CRUSIER_FOURTH_GENERATION.highRiskVehicleModelValue(), //match high risk model
                "US" //ok
        );

        TheftRiskRatingService theftRiskRatingService = new TheftRiskRatingService();
        Integer result = theftRiskRatingService.rateTheftRisk(command);
        assertThat(result, is(30));
    }

    private RateTheftRiskCommand createRateTheftRiskCommand(String licensePlate, String vehicleModel, String registrationCountry) {
        return new RateTheftRiskCommand(
                new LicensePlate(licensePlate),
                new VehicleModel(vehicleModel),
                new RegistrationCountry(registrationCountry),
                createHighRiskCountries(),
                createHighRiskVehicleModels()
        );
    }

    private HighRiskVehicleModels createHighRiskVehicleModels() {
        return new HighRiskVehicleModels(
                Arrays.asList(HighRiskVehicleModel.GRAND_CHEROKEE_FOURTH_GENERATION,
                        HighRiskVehicleModel.RANGE_ROVER_SECOND_GENERATION,
                        HighRiskVehicleModel.RANGE_ROVER_THIRD_GENERATION,
                        HighRiskVehicleModel.STRINGER_FIRST_GENERATION,
                        HighRiskVehicleModel.LAND_CRUSIER_FOURTH_GENERATION)
        );
    }

    private HighRiskCountries createHighRiskCountries() {
        return new HighRiskCountries(
                Arrays.asList(new HighRiskCountry(CountryCode.FR),
                        new HighRiskCountry(CountryCode.IT),
                        new HighRiskCountry(CountryCode.ESP),
                        new HighRiskCountry(CountryCode.GB),
                        new HighRiskCountry(CountryCode.DE)
                ),
                Arrays.asList(
                        new HighRiskCountry(CountryCode.BZ),
                        new HighRiskCountry(CountryCode.MEX),
                        new HighRiskCountry(CountryCode.RU),
                        new HighRiskCountry(CountryCode.SA),
                        new HighRiskCountry(CountryCode.USA)
                )
        );
    }
}