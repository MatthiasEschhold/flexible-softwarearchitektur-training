package de.arkem.clean.arc.demo.app.lab.a.vehicle.domain.model;

public record EquipmentCode(String value) {

    private static final String EQUIPMENT_CODE_PATTERN = "^[A-Z]{2}[0-9]{4}$";

    public EquipmentCode {
        validateEquipmentCode(value);
    }

    private void validateEquipmentCode(String value) {
        if (!isValidEquipmentCode(value)) {
            throw new IllegalArgumentException("equipment code is not valid");
        }
    }

    private boolean isValidEquipmentCode(String value) {
        return value != null && value.matches(EQUIPMENT_CODE_PATTERN);
    }
}
