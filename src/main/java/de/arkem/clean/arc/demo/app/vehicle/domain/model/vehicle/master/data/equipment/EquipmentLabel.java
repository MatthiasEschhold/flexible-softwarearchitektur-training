package de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.equipment;

public record EquipmentLabel(String value) {
    private final static String EQUIPMENT_LABEL_PATTERN = "^[A-Za-z\\s]+$";

    public EquipmentLabel {
        validateEquipmentLabel(value);
    }

    private void validateEquipmentLabel(String value) {
        if (value.isBlank() || !value.matches(EQUIPMENT_LABEL_PATTERN)) {
            throw new IllegalArgumentException("equipment label is not valid");
        }
    }
}
