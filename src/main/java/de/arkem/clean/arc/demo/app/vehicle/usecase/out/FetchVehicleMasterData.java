package de.arkem.clean.arc.demo.app.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.master.data.VehicleMasterData;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
