package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.dto;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;

public record VehicleQueryResult(Vin vin, VehicleMotionData vehicleMotionData) {
}
