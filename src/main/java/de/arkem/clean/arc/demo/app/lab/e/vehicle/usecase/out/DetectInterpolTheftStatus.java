package de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.theft.status.TheftStatus;

public interface DetectInterpolTheftStatus {
    TheftStatus detect(Vin vin, LicensePlate licensePlate);
}
