package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.in.api;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.MileageResource;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.resource.VehicleMotionDataResource;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface VehicleToEntityApiMapper {
    @Mapping(source = "licensePlate", target = "licensePlate.value")
    VehicleMotionData mapVehicleMotionDataToEntity(VehicleMotionDataResource resource);

    @Mapping(source = "value", target = "value")
    Vin mapVinToEntity(String value);

    @Mapping(source = "value", target = "mileageValue.value")
    @Mapping(source = "unit", target = "mileageUnit", qualifiedByName = "mapMileageUnitEnum")
    Mileage mapMileageToEntity(MileageResource resource);

    @Named("mapMileageUnitEnum")
    private MileageUnit mapMileageUnitEnum(String value) {
        return MileageUnit.valueOf(value);
    }
}
