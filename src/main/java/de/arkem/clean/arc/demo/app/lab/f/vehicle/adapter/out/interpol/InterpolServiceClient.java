package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.out.interpol;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.theft.status.TheftStatusEnum;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.out.DetectInterpolTheftStatus;

public class InterpolServiceClient implements DetectInterpolTheftStatus {
    @Override
    public TheftStatus detect(Vin vin, LicensePlate licensePlate) {
        return new TheftStatus(TheftStatusEnum.STOLEN);
    }
}
