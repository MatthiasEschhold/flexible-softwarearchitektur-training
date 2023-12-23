package de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.vehicle;

public record LicensePlate(String value) {
    private final static String LICENSE_PLATE_PATTERN = "[A-ZÖÜÄ0-9]{1,5}[-]{0,1}[A-ZÖÜÄ0-9]{0,10}[-]{0,1}[A-ZÖÜÄ0-9]{0,4}";
    public final static String EU_LICENSE_PLATE_PATTERN = "[A-ZÖÜÄ0-9]{1,5}[-]{0,1}[A-ZÖÜÄ0-9]{0,10}[-]{0,1}[A-ZÖÜÄ0-9]{0,4}";
    public final static String GERMAN_LICENSE_PLATE_PATTERN = "[A-ZÖÜÄ0-9]{1,5}[-]{0,1}[A-ZÖÜÄ0-9]{0,10}[-]{0,1}[A-ZÖÜÄ0-9]{0,4}";
    public final static String FRANCE_LICENSE_PLATE_PATTERN = "[A-ZÖÜÄ0-9]{1,5}[-]{0,1}[A-ZÖÜÄ0-9]{0,10}[-]{0,1}[A-ZÖÜÄ0-9]{0,4}";
    public LicensePlate {
        validateLicensePlate(value);
    }

    private void validateLicensePlate(String value) {
        if (!isValidLicensePlate(value)) {
            throw new IllegalStateException("license plate is not valid");
        }
    }

    private boolean isValidLicensePlate(String value) {
        return value != null && value.matches(LICENSE_PLATE_PATTERN);
    }

    public boolean isEuLicensePlate() {
        return value.matches(EU_LICENSE_PLATE_PATTERN);
    }

    public boolean isGermanLicensePlate() {
        return value.matches(GERMAN_LICENSE_PLATE_PATTERN);
    }

    public boolean isFranceLicensePlate() {
        return value.matches(FRANCE_LICENSE_PLATE_PATTERN);
    }
}
