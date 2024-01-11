package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle;

public record LicensePlate(String value) {
    private static final String EU_LICENSE_PLATE_PATTERN = "^[A-Z]{1,3}[a-z]{0,1}[-]{0,1}[A-Z]{0,2}\\s[0-9]{1,5}(\\s){0,1}[A-Z]{0,1}[a-z]{0,2}$";
    private static final String ITALIAN_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String GERMANY_LICENSE_PLATE_PATTERN = "^[A-Z]{1,3}-[A-Z]{1,2}\\s[0-9]{1,4}$";
    private static final String SPAIN_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String FRANCE_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String GREAT_BRITIAN_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String SAUDIA_ARABIA_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String RUSSIA_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String MEXICO_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String BRAZIL_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";
    private static final String USA_LICENSE_PLATE_PATTERN = "^[A-Z]{1}[a-z]{0,1}\\s[0-9]{1,5}\\s[A-Z]{1}[a-z]{0,2}$";

    public LicensePlate {
        validateLicensePlate(value);
    }

    private void validateLicensePlate(String value) {
        if (!isValidLicensePlate(value)) {
            throw new IllegalArgumentException("license plate is not valid");
        }
    }

    private boolean isValidLicensePlate(String value) {
        return value != null && value.matches(EU_LICENSE_PLATE_PATTERN);
    }

    public boolean isFranceLicensePlate() {
        return value.matches(FRANCE_LICENSE_PLATE_PATTERN);
    }

    public boolean isSpainLicensePlate() {
        return value.matches(SPAIN_LICENSE_PLATE_PATTERN);
    }

    public boolean isGreatBritianLicensePlate() {
        return value.matches(GREAT_BRITIAN_LICENSE_PLATE_PATTERN);
    }

    public boolean isItalianLicensePlate() {
        return value.matches(ITALIAN_LICENSE_PLATE_PATTERN);
    }

    public boolean isGermanyLicensePlate() {
        return value.matches(GERMANY_LICENSE_PLATE_PATTERN);
    }

    public boolean isSaudiArabiaLicensePlate() {
        return value.matches(SAUDIA_ARABIA_LICENSE_PLATE_PATTERN);
    }

    public boolean isRussiaLicensePlate() {
        return value.matches(RUSSIA_LICENSE_PLATE_PATTERN);
    }

    public boolean isMexicoLicensePlate() {
        return value.matches(MEXICO_LICENSE_PLATE_PATTERN);
    }

    public boolean isBrazilLicensePlate() {
        return value.matches(BRAZIL_LICENSE_PLATE_PATTERN);
    }

    public boolean isUsaLicensePlate() {
        return value.matches(USA_LICENSE_PLATE_PATTERN);
    }

    public boolean isEuropeanLicensePlate() {
        return value.matches(EU_LICENSE_PLATE_PATTERN);
    }
}
