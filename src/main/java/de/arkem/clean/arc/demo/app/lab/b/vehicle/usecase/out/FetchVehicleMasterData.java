package de.arkem.clean.arc.demo.app.lab.b.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.b.vehicle.domain.model.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.b.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
