package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data;

public record LicensePlate(String value) {

    private final static String LICENSE_PLATE_PATTERN = "^(?=.{4,10}$)([A-Z]{1,3}[-\\s]){0,2}[A-Z0-9]{2,4}\\s\\d{2,4}$";

    private final static String GERMAN_LICENSE_PLATE_PATTERN = "^[A-Z]{1,3}-[A-Z0-9]{1,2}\\s\\d{1,4}$";

    public LicensePlate {
        validateLicensePlate(value);
    }

    private void validateLicensePlate(String value) {
        if (!isValidLicensePlate(value)) {
            throw new IllegalArgumentException("license plate is not valid");
        }
    }

    private boolean isValidLicensePlate(String value) {
        return value != null && value.matches(LICENSE_PLATE_PATTERN);
    }

    public boolean isGermanLicenselate() {
        return value.matches(GERMAN_LICENSE_PLATE_PATTERN);
    }
}
