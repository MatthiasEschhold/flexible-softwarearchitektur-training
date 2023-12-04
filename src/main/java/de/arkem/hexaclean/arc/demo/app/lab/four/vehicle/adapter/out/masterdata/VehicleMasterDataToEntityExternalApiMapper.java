package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.out.masterdata;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.*;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleMasterDataToEntityExternalApiMapper {
    public VehicleMasterData mapVehicleMasterDataToEntity(VehicleDataDto resource) {
        List<Equipment> equipmentList = resource.getEquipmentListDto().getList()
                .stream()
                .map(this::createEquipment)
                .collect(Collectors.toList());
        return new VehicleMasterData(equipmentList, new RegistrationCountry(resource.getRegistrationCountry()));
    }

    private Equipment createEquipment(EquipmentDto dto) {
        return new Equipment(new EquipmentCode(dto.getCode()), new EquipmentLabel(dto.getName()));
    }
}