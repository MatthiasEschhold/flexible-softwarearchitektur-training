package de.arkem.clean.arc.demo.app.lab.f.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.master.data.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
