package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.theft.status;

public record HighRiskCountry(CountryCode value) {
    private static final String COUNTRY_CODE_PATTERN = "[A-Z]{2}";

    public HighRiskCountry {
        validateHighRiskCountry(value.countryCodeValue());
    }

    private void validateHighRiskCountry(String value) {
        if (!isHighRiskCountryValid(value)) {
            throw new IllegalStateException("high risk country is not valid");
        }
    }

    private boolean isHighRiskCountryValid(String value) {
        return value != null && value.matches(COUNTRY_CODE_PATTERN);
    }
}
