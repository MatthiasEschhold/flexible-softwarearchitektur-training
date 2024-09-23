package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.vehicle;

import io.github.domainprimitives.object.ComposedValueObject;

import java.util.List;

public class Vehicle extends ComposedValueObject {
    private final Vin vin;
    private List<EquipmentCode> equipmentCodes;

    public Vehicle(Vin vin, List<EquipmentCode> equipmentCodes) {
        this.vin = vin;
        this.equipmentCodes = equipmentCodes;
    }
    @Override
    protected void validate() {
        if (vin == null) {
            throw new IllegalArgumentException("vin is not valid");
        }
        if (equipmentCodes == null) {
            throw new IllegalArgumentException("equipmentCodes is not valid");
        }
    }
    public Vin getVin() {
        return vin;
    }

    public List<EquipmentCode> getEquipmentCodes() {
        return equipmentCodes;
    }
}
