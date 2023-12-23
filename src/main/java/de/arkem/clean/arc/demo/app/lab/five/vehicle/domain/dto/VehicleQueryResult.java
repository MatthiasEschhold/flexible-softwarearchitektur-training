package de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.dto;

import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;

public record VehicleQueryResult(Vin vin, VehicleMotionData vehicleMotionData) {
}
