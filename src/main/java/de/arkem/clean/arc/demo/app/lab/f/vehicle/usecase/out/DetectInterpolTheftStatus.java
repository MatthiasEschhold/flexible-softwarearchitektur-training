package de.arkem.clean.arc.demo.app.lab.f.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.Vin;

public interface DetectInterpolTheftStatus {
    TheftStatus detect(Vin vin, LicensePlate licensePlate);
}
