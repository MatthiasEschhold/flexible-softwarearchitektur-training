package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.equipment.Equipment;

import java.util.List;

public record VehicleMasterData(List<Equipment> equipmentList, RegistrationCountry registrationCountry,
                                VehicleModel vehicleModel) {

    public VehicleMasterData {
        validateVehicleMasterData(equipmentList, registrationCountry, vehicleModel);
    }

    private void validateVehicleMasterData(List<Equipment> equipmentList, RegistrationCountry registrationCountry, VehicleModel vehicleModel) {
        if (isVehicleMasterDataValid(equipmentList, registrationCountry, vehicleModel)) {
            throw new IllegalStateException("equipment list is not valid");
        }
    }

    private boolean isVehicleMasterDataValid(List<Equipment> equipmentList, RegistrationCountry registrationCountry, VehicleModel vehicleModel) {
        return equipmentList != null && !equipmentList.isEmpty() && registrationCountry != null && vehicleModel != null;
    }

}
