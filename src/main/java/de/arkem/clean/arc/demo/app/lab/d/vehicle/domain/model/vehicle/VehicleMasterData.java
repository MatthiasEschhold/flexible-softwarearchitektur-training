package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle;

import java.util.List;

public record VehicleMasterData(List<Equipment> equipmentList, RegistrationCountry registrationCountry, VehicleModel vehicleModel) {

    public VehicleMasterData {
        validateVehicleMasterData(equipmentList);
    }

    private void validateVehicleMasterData(List<Equipment> equipmentList) {
        if (!isVehicleMasterDataValid(equipmentList)) {
            throw new IllegalArgumentException("vehicle master data is not valid");
        }
    }

    private boolean isVehicleMasterDataValid(List<Equipment> equipmentList) {
        return equipmentList != null && !equipmentList.isEmpty();
    }

}
