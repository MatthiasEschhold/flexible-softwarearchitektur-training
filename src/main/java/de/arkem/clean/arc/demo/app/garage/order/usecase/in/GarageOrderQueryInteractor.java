package de.arkem.clean.arc.demo.app.garage.order.usecase.in;

import de.arkem.clean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.clean.arc.demo.app.garage.order.domain.model.OrderNumber;

import java.util.List;

class GarageOrderQueryInteractor implements GarageOrderQuery {
    private final GarageOrderDbQuery dbQuery;

    public GarageOrderQueryInteractor(GarageOrderDbQuery dbQuery) {
        this.dbQuery = dbQuery;
    }

    @Override
    public GarageOrder read(OrderNumber orderNumber) {
        return dbQuery.findByOrderNumber(orderNumber).orElseThrow(() -> new IllegalArgumentException("garage order not found"));
    }

    @Override
    public List<GarageOrder> readAll() {
        return dbQuery.findAll();
    }
}
