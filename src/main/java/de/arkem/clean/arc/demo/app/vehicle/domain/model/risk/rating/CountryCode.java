package de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating;

public record CountryCode(String value) {
    private static final String COUNTRY_CODE_PATTERN = "^[A-Z]{2}$";

    public CountryCode {
        if (value == null || !value.matches(COUNTRY_CODE_PATTERN)) {
            throw new IllegalArgumentException("country of manufacture is not valid");
        }
    }
}
