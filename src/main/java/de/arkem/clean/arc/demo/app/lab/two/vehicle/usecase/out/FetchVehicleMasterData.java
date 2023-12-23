package de.arkem.clean.arc.demo.app.lab.two.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.two.vehicle.domain.model.VehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.two.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
