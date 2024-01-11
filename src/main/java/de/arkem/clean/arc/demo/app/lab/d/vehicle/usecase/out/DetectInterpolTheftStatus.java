package de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vin;

public interface DetectInterpolTheftStatus {
    TheftStatus detect(Vin vin, LicensePlate licensePlate);
}
