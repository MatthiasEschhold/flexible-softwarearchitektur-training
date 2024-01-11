package de.arkem.clean.arc.demo.app.lab.f.garage.order.usecase.out;

import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.GarageOrder;

public interface GarageOrderDbCommand {
    GarageOrder save(GarageOrder garageOrder);
}
