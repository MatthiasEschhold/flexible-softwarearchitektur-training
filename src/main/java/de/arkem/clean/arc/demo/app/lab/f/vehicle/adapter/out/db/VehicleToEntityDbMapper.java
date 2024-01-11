package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.db.VehicleDbEntity;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageUnit;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageValue;

public class VehicleToEntityDbMapper {
    public VehicleMotionData mapVehicleMotionDataToEntity(VehicleDbEntity dbEntity) {
        return new VehicleMotionData(new LicensePlate(dbEntity.getLicensePlate()),
                new Mileage(MileageUnit.valueOf(dbEntity.getMileageUnit()),
                        new MileageValue(dbEntity.getMileage())));
    }
}
