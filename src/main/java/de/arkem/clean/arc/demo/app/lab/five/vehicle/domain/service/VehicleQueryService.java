package de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.service;

import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.in.VehicleQuery;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out.VehicleRepository;

public class VehicleQueryService implements VehicleQuery {

    private final VehicleRepository repository;
    private final FetchVehicleMasterData fetchVehicleMasterData;

    //@Autowired
    public VehicleQueryService(VehicleRepository repository, FetchVehicleMasterData fetchVehicleMasterData) {
        this.repository = repository;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }
    @Override
    public Vehicle findByVin(Vin vin) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        VehicleMotionData vehicleMotionData = repository.findVehicleMotionDataByVin(vin);
        return new Vehicle(vin, vehicleMotionData, vehicleMasterData);
    }
}
