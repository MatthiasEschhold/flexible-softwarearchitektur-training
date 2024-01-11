package de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.in.VehicleCommand;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.out.VehicleRepository;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vin;

public class VehicleService implements VehicleCommand {

    private final VehicleRepository repository;
    private final FetchVehicleMasterData fetchVehicleMasterData;

    //@Autowired
    public VehicleService(VehicleRepository repository, FetchVehicleMasterData fetchVehicleMasterData) {
        this.repository = repository;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    @Override
    public Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        Vehicle vehicle = new Vehicle(vin, vehicleMotionData, vehicleMasterData);
        repository.save(vin, vehicleMotionData);
        return vehicle;
    }
}
