package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.masterdata.EquipmentDto;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.masterdata.VehicleDataDto;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.VehicleModel;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.equipment.EquipmentCode;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.equipment.EquipmentLabel;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleMasterDataToEntityExternalApiMapper {
    public VehicleMasterData mapVehicleMasterDataToEntity(VehicleDataDto resource) {
        List<Equipment> equipmentList = resource.getEquipmentListDto().getList()
                .stream()
                .map(this::createEquipment)
                .collect(Collectors.toList());
        return new VehicleMasterData(equipmentList,
                new RegistrationCountry(resource.getRegistrationCountry()),
                new VehicleModel(resource.getModel()));
    }

    private Equipment createEquipment(EquipmentDto dto) {
        return new Equipment(new EquipmentCode(dto.getCode()), new EquipmentLabel(dto.getName()));
    }
}
