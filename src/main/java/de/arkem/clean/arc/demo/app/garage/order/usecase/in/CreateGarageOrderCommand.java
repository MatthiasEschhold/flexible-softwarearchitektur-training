package de.arkem.clean.arc.demo.app.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;

public record CreateGarageOrderCommand(LicensePlate licensePlate) {
}
