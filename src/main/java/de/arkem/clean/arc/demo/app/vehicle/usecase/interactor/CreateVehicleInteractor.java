package de.arkem.clean.arc.demo.app.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.CreateVehicle;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.SaveVehicle;

public class CreateVehicleInteractor implements CreateVehicle {
    private final SaveVehicle saveVehicle;
    private final FetchVehicleMasterData fetchVehicleMasterData;

    public CreateVehicleInteractor(SaveVehicle saveVehicle, FetchVehicleMasterData fetchVehicleMasterData) {
        this.saveVehicle = saveVehicle;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    @Override
    public Vehicle create(Vin vin, LicensePlate licensePlate, Mileage mileage) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        Vehicle vehicle = new Vehicle(vin, licensePlate, mileage, vehicleMasterData);
        return saveVehicle.save(vehicle);
    }
}
