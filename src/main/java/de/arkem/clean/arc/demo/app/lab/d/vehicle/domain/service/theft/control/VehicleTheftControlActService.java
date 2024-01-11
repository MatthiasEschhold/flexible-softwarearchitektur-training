package de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.service.theft.control;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.RegistrationCountry;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.VehicleModel;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.service.risk.rating.TheftRiskRatingService;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.TheftStatusEnum;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out.DetectInterpolTheftStatus;

public class VehicleTheftControlActService {
    final TheftRiskRatingService theftRiskRatingService;
    final DetectInterpolTheftStatus detectInterpolTheftStatus;

    public VehicleTheftControlActService(TheftRiskRatingService theftRiskRatingService, DetectInterpolTheftStatus detectInterpolTheftStatus) {
        this.theftRiskRatingService = theftRiskRatingService;
        this.detectInterpolTheftStatus = detectInterpolTheftStatus;
    }

    public void performSuccesfulOrThrowException(Vin vin, LicensePlate licensePlate, RegistrationCountry registrationCountry, VehicleModel vehicleModel) {
        Integer ratingResult = theftRiskRatingService.rateTheftRisk(licensePlate, vehicleModel, registrationCountry);
        if (ratingResult > 75) {
            TheftStatus theftStatus = detectInterpolTheftStatus.detect(vin, licensePlate);
            if (isVehicleStolen(theftStatus)) {
                throw new IllegalStateException("interpol is informed and on the way");
            }
        }
    }

    boolean isVehicleStolen(TheftStatus theftStatus) {
        return theftStatus.value().equals(TheftStatusEnum.STOLEN.toString());
    }
}