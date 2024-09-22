package de.arkem.clean.arc.demo.app.vehicle.usecase.in;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.Mileage;

public interface UpdateMileage {
    void update(Vin vin, Mileage mileage);
}
