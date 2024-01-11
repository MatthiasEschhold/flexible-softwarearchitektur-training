package de.arkem.clean.arc.demo.app.lab.c.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.c.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
