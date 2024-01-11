package de.arkem.clean.arc.demo.app.lab.c.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vin;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.out.VehicleRepository;

public class VehicleDbRepository implements VehicleRepository {

    private final VehicleToDbEntityDbMapper mapper;
    private final VehicleCrudRepository crudRepository;

    public VehicleDbRepository(VehicleToDbEntityDbMapper mapper, VehicleCrudRepository crudRepository) {
        this.mapper = mapper;
        this.crudRepository = crudRepository;
    }

    @Override
    public VehicleMotionData save(Vin vin, VehicleMotionData vehicleMotionData) {
        return mapper.mapVehicleDbEntityToVehicleMotionData(
                crudRepository.save(mapper.mapVehicleToDbEntity(vin, vehicleMotionData))
        );
    }

}
