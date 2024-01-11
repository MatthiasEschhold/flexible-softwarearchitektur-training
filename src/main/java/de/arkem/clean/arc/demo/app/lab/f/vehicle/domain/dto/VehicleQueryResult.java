package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.dto;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;

public record VehicleQueryResult(Vin vin, VehicleMotionData vehicleMotionData) {
}
