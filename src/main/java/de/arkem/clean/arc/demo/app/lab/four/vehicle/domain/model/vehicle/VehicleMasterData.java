package de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.vehicle;

import java.util.List;

public record VehicleMasterData(List<Equipment> equipmentList) {

    public VehicleMasterData {
        validateVehicleMasterData(equipmentList);
    }

    private void validateVehicleMasterData(List<Equipment> equipmentList) {
        if (isVehicleMasterDataValid(equipmentList)) {
            throw new IllegalStateException("equipment list is not valid");
        }
    }
    private boolean isVehicleMasterDataValid(List<Equipment> equipmentList) {
        return equipmentList != null && !equipmentList.isEmpty();
    }

}
