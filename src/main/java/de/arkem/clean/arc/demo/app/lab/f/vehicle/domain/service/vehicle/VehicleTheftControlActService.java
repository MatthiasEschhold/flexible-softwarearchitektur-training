package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.service.vehicle;

import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.master.data.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.master.data.VehicleModel;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.service.risk.rating.RateTheftRiskCommand;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.service.risk.rating.TheftRiskRatingService;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.theft.status.TheftStatusEnum;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.usecase.out.DetectInterpolTheftStatus;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.service.risk.rating.RateTheftRiskCommandFactory;

public class VehicleTheftControlActService {
    final TheftRiskRatingService theftRiskRatingService;
    final DetectInterpolTheftStatus detectInterpolTheftStatus;
    final RateTheftRiskCommandFactory rateTheftRiskCommandFactory;

    public VehicleTheftControlActService(TheftRiskRatingService theftRiskRatingService, DetectInterpolTheftStatus detectInterpolTheftStatus, RateTheftRiskCommandFactory rateTheftRiskCommandFactory) {
        this.theftRiskRatingService = theftRiskRatingService;
        this.detectInterpolTheftStatus = detectInterpolTheftStatus;
        this.rateTheftRiskCommandFactory = rateTheftRiskCommandFactory;
    }

    public void performSuccesfulOrThrowException(Vin vin, LicensePlate licensePlate, RegistrationCountry registrationCountry, VehicleModel vehicleModel) {
        Integer ratingResult = theftRiskRatingService.rateTheftRisk(createCommand(licensePlate, registrationCountry, vehicleModel));
        if (ratingResult > 75) {
            TheftStatus theftStatus = detectInterpolTheftStatus.detect(vin, licensePlate);
            if (isVehicleStolen(theftStatus)) {
                throw new IllegalStateException("interpol is informed and on the way");
            }
        }
    }
    private RateTheftRiskCommand createCommand(LicensePlate licensePlate, RegistrationCountry registrationCountry, VehicleModel vehicleModel) {
        return rateTheftRiskCommandFactory.create(licensePlate, vehicleModel, registrationCountry);
    }
    boolean isVehicleStolen(TheftStatus theftStatus) {
        return theftStatus.value().equals(TheftStatusEnum.STOLEN.toString());
    }
}