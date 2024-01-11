package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.service.vehicle;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.service.theft.control.VehicleTheftControlActService;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.in.VehicleCommand;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out.VehicleRepository;

public class VehicleCommandService implements VehicleCommand {

    private final VehicleRepository repository;
    private final FetchVehicleMasterData fetchVehicleMasterData;
    private final VehicleTheftControlActService vehicleTheftControlActService;

    //@Autowired
    public VehicleCommandService(VehicleRepository repository, FetchVehicleMasterData fetchVehicleMasterData,
                                 VehicleTheftControlActService vehicleTheftControlActService) {
        this.repository = repository;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.vehicleTheftControlActService = vehicleTheftControlActService;
    }

    @Override
    public Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        performTheftControlAct(vin, vehicleMotionData, vehicleMasterData);
        Vehicle vehicle = new Vehicle(vin, vehicleMotionData, vehicleMasterData);
        repository.save(vehicle.getVin(), vehicle.getVehicleMotionData());
        return vehicle;
    }

    private void performTheftControlAct(Vin vin, VehicleMotionData vehicleMotionData, VehicleMasterData vehicleMasterData) {
        vehicleTheftControlActService.performSuccesfulOrThrowException(vin,
                vehicleMotionData.licensePlate(),
                vehicleMasterData.registrationCountry(),
                vehicleMasterData.vehicleModel());
    }

}
