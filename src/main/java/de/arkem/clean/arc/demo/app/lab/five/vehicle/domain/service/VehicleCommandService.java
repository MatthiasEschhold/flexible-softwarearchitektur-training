package de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.service;

import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.theft.status.TheftStatusEnum;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.in.VehicleCommand;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out.DetectInterpolTheftStatus;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out.FetchHighRiskCountries;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out.VehicleRepository;

public class VehicleCommandService implements VehicleCommand {

    private final VehicleRepository repository;
    private final FetchVehicleMasterData fetchVehicleMasterData;
    private final TheftRiskRatingService theftRiskRatingService;
    private final DetectInterpolTheftStatus detectInterpolTheftStatus;
    private final FetchHighRiskCountries fetchHighRiskCountries;

    //@Autowired
    public VehicleCommandService(VehicleRepository repository, FetchVehicleMasterData fetchVehicleMasterData,
                                 TheftRiskRatingService theftRiskRatingService, DetectInterpolTheftStatus detectInterpolTheftStatus, FetchHighRiskCountries fetchHighRiskCountries) {
        this.repository = repository;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.theftRiskRatingService = theftRiskRatingService;
        this.detectInterpolTheftStatus = detectInterpolTheftStatus;
        this.fetchHighRiskCountries = fetchHighRiskCountries;
    }

    @Override
    public Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        Integer ratingResult = theftRiskRatingService.rateTheftRisk(vehicleMasterData.registrationCountry(), vehicleMotionData.licensePlate(), fetchHighRiskCountries.fetch());
        if (ratingResult > 75) {
            TheftStatus theftStatus = detectInterpolTheftStatus.detect(vin, vehicleMotionData.licensePlate());
            if (isVehicleStolen(theftStatus)) {
                throw new IllegalStateException("interpol is informed and on the way");
            }
        }
        repository.save(vin, vehicleMotionData);
        return new Vehicle(vin, vehicleMotionData, vehicleMasterData);
    }

    private boolean isVehicleStolen(TheftStatus theftStatus) {
        return theftStatus.value().equals(TheftStatusEnum.STOLEN.toString());
    }

}
