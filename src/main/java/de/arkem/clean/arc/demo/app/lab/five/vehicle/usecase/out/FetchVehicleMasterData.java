package de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
