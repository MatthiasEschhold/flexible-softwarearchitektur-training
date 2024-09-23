package de.arkem.clean.arc.demo.app.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.garage.order.domain.model.GarageOrder;

public interface GarageOrderCommand {
    GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand);
    GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand);
}
