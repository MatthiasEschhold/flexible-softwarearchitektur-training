package de.arkem.clean.arc.demo.app.lab.d.vehicle.adapter.out.interpol;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out.DetectInterpolTheftStatus;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.vehicle.Vin;

public class InterpolServiceClient implements DetectInterpolTheftStatus {
    @Override
    public TheftStatus detect(Vin vin, LicensePlate licensePlate) {
        return null;
    }
}
