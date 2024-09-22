package de.arkem.clean.arc.demo.app.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.DetectTheftStatus;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FetchRiskCountries;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.SaveVehicle;

import java.util.List;

public class CreateVehicleInteractor implements CreateVehicle {
    private final SaveVehicle saveVehicle;
    private final FetchVehicleMasterData fetchVehicleMasterData;
    private final TheftRiskRatingService theftRiskRatingService;
    private final DetectTheftStatus detectTheftStatus;
    private final FetchRiskCountries fetchRiskCountries;

    public CreateVehicleInteractor(SaveVehicle saveVehicle, FetchVehicleMasterData fetchVehicleMasterData, TheftRiskRatingService theftRiskRatingService, DetectTheftStatus detectTheftStatus, FetchRiskCountries fetchRiskCountries) {
        this.saveVehicle = saveVehicle;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.theftRiskRatingService = theftRiskRatingService;
        this.detectTheftStatus = detectTheftStatus;
        this.fetchRiskCountries = fetchRiskCountries;
    }

    @Override
    public Vehicle create(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        int riskScore = detectRiskScore(vehicleMasterData, licensePlate);
        performTheftCheck(riskScore, vin);
        return saveVehicle(vin, licensePlate, mileage, vehicleMasterData);
    }

    private void performTheftCheck(int riskScore, Vin vin) {
        if (riskScore >= 50) {
            if (detectTheftStatus.detect(vin).value()) {
                throw new IllegalStateException("vehicle is stolen");
            }
        }
    }

    private Vehicle saveVehicle(Vin vin, LicensePlate licensePlate, Mileage mileage, VehicleMasterData vehicleMasterData) {
        Vehicle vehicle = new Vehicle(vin, licensePlate, mileage, vehicleMasterData);
        return saveVehicle.save(vehicle);
    }

    private int detectRiskScore(VehicleMasterData vehicleMasterData, LicensePlate licensePlate) {
        List<CountryCode> riskCountries = fetchRiskCountries.fetch();
        CountryCode registrationCountry = detectRegistrationCountry(licensePlate);
        return theftRiskRatingService.detectRiskScore(vehicleMasterData.countryOfManufacture(), riskCountries, registrationCountry);
    }

    private CountryCode detectRegistrationCountry(LicensePlate licensePlate) {
        // magic...
        return new CountryCode("DE");
    }
}
