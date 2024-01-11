package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle;

public record RegistrationCountry(String value) {

    private static final String COUNTRY_CODE_PATTERN = "[A-Z]{2}";

    public RegistrationCountry {
        validateRegistrationCountry(value);
    }

    private void validateRegistrationCountry(String value) {
        if (!isRegistrationCountryValid(value)) {
            throw new IllegalStateException("registration country is not valid");
        }
    }

    private boolean isRegistrationCountryValid(String value) {
        return value != null && value.matches(COUNTRY_CODE_PATTERN);
    }
}

