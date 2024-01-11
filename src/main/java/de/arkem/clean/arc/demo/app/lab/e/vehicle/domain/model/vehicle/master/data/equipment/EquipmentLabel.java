package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.equipment;

public record EquipmentLabel(String value) {
    public EquipmentLabel {
        validateEquipmentLabel(value);
    }

    private void validateEquipmentLabel(String value) {
        if (!isValidEquipmentLabel(value)) {
            throw new IllegalStateException("equipment label is not valid");
        }
    }

    private boolean isValidEquipmentLabel(String value) {
        return value != null && !value.isBlank();
    }
}
