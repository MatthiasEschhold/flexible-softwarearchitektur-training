package de.arkem.clean.arc.demo.app.lab.c.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Equipment;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.EquipmentCode;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.EquipmentLabel;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMasterData;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleMasterDataToEntityExternalApiMapper {
    public VehicleMasterData mapVehicleMasterDataToEntity(VehicleDataDto resource) {
        List<Equipment> equipmentList = resource.getEquipmentListDto().getList()
                .stream()
                .map(this::createEquipment)
                .collect(Collectors.toList());
        return new VehicleMasterData(equipmentList);
    }

    private Equipment createEquipment(EquipmentDto dto) {
        return new Equipment(new EquipmentCode(dto.getCode()), new EquipmentLabel(dto.getName()));
    }
}
