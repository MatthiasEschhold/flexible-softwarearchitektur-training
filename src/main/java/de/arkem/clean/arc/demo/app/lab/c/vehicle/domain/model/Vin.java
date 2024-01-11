package de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model;

public record Vin(String value) {
    private static final String VIN_PATTERN = "(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}";

    public Vin {
        validateVin(value);
    }

    private void validateVin(String value) {
        if (!isValidVin(value)) {
            throw new IllegalArgumentException("vin is not valid");
        }
    }

    private boolean isValidVin(String value) {
        return value != null && value.matches(VIN_PATTERN);
    }
}
