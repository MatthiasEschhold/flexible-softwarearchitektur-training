package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.theft.status;

import java.util.List;

public record HighRiskCountries(List<HighRiskCountry> highRiskCountriesEurope, List<HighRiskCountry> highRiskCountriesNonEurope) {
    public HighRiskCountries(List<HighRiskCountry> highRiskCountriesEurope, List<HighRiskCountry> highRiskCountriesNonEurope) {
        this.highRiskCountriesEurope = highRiskCountriesEurope;
        this.highRiskCountriesNonEurope = highRiskCountriesNonEurope;
    }
}
