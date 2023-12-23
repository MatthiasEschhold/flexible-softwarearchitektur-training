package de.arkem.clean.arc.demo.app.lab.three.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.three.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
