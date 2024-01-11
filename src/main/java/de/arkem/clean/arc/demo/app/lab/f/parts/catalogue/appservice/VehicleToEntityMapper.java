package de.arkem.clean.arc.demo.app.lab.f.parts.catalogue.appservice;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleToEntityMapper {

    @Mapping(source = "vin.value", target = "vin")
    @Mapping(source = "vehicleMasterData.vehicleModel.value", target = "vehicleModel")
    de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle mapToEntity(Vehicle origin);
}
