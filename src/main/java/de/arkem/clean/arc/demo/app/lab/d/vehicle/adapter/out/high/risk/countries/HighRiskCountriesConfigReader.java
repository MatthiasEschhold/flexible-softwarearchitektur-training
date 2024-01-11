package de.arkem.clean.arc.demo.app.lab.d.vehicle.adapter.out.high.risk.countries;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.CountryCode;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskCountries;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskCountry;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out.FetchHighRiskCountries;

import java.util.Arrays;

public class HighRiskCountriesConfigReader implements FetchHighRiskCountries {
    @Override
    public HighRiskCountries fetch() {
        return createHighRiskCountries();
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
