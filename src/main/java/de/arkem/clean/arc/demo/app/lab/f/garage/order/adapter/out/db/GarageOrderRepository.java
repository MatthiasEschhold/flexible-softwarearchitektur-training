package de.arkem.clean.arc.demo.app.lab.f.garage.order.adapter.out.db;

import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.OrderNumber;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.usecase.out.GarageOrderDbCommand;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.usecase.out.GarageOrderDbQuery;

public class GarageOrderRepository implements GarageOrderDbCommand, GarageOrderDbQuery {

    @Override
    public GarageOrder save(GarageOrder garageOrder) {
        return null;
    }

    @Override
    public GarageOrder findByOrderNumber(OrderNumber orderNumber) {
        return null;
    }
}
