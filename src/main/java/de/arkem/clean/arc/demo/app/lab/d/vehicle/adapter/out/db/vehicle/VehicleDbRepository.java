package de.arkem.clean.arc.demo.app.lab.d.vehicle.adapter.out.db.vehicle;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out.VehicleRepository;

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

    @Override
    public VehicleMotionData findVehicleMotionDataByVin(Vin vin) {
        return findVehicleMotionDataMock();
    }

    private VehicleMotionData findVehicleMotionDataMock() {
        return new VehicleMotionData(new LicensePlate("ES-EL 0815"));
    }
}
