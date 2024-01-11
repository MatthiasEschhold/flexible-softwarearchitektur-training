package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.out.db;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.db.VehicleCrudRepository;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.db.VehicleToDbEntityDbMapper;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.db.VehicleToEntityDbMapper;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.dto.VehicleQueryResult;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageUnit;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageValue;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.out.VehicleRepository;

public class VehicleDbRepository implements VehicleRepository {

    private final VehicleToDbEntityDbMapper dbEntityMapper;
    private final VehicleToEntityDbMapper entityMapper;
    private final VehicleCrudRepository crudRepository;

    public VehicleDbRepository(VehicleToDbEntityDbMapper dbEntityMapper, VehicleToEntityDbMapper entityMapper, VehicleCrudRepository crudRepository) {
        this.dbEntityMapper = dbEntityMapper;
        this.entityMapper = entityMapper;
        this.crudRepository = crudRepository;
    }

    @Override
    public void save(Vin vin, VehicleMotionData vehicleMotionData) {
        crudRepository.save(dbEntityMapper.mapVehicleToDbEntity(vin, vehicleMotionData));
    }

    @Override
    public VehicleMotionData findVehicleMotionDataByVin(Vin vin) {
        return findVehicleMotionDataMock();
    }

    @Override
    public VehicleQueryResult findVehicleMotionDataByLicensePlate(LicensePlate licensePlate) {
        return new VehicleQueryResult(new Vin(""), findVehicleMotionDataMock());
    }

    private VehicleMotionData findVehicleMotionDataMock() {
        return new VehicleMotionData(new LicensePlate("ES-EL 0815"),
                new Mileage(MileageUnit.KM, new MileageValue(14000.00)));
    }

}
