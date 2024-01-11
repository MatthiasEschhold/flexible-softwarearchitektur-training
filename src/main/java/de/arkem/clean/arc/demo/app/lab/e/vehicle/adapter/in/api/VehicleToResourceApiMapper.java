package de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.resource.EquipmentResource;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.resource.VehicleMasterDataResource;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.resource.VehicleMotionDataResource;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.equipment.Equipment;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleToResourceApiMapper {
    @Mapping(source = "vin.value", target = "vin")
    @Mapping(source = "vehicleMotionData", target = "vehicleMotionData")
    @Mapping(source = "vehicleMasterData", target = "vehicleMasterData")
    VehicleResource mapVehicleToResource(Vehicle vehicle);

    @Mapping(source = "licensePlate.value", target = "licensePlate")
    VehicleMotionDataResource mapVehicleMotionDataToResource(VehicleMotionData entity);

    @Mapping(source = "equipmentList", target = "equipmentList")
    VehicleMasterDataResource mapVehicleMasterDataToResource(VehicleMasterData entity);

    @Mapping(source = "equipmentCode.value", target = "equipmentCode")
    @Mapping(source = "equipmentLabel.value", target = "equipmentLabel")
    EquipmentResource mapEquipmentToResource(Equipment entity);

}
