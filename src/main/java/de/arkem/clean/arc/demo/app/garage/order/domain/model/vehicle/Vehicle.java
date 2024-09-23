package de.arkem.clean.arc.demo.app.garage.order.domain.model.vehicle;

import io.github.domainprimitives.object.ComposedValueObject;

public class Vehicle extends ComposedValueObject {
    LicensePlate licencePlate;
    Mileage mileage;

    public Vehicle(LicensePlate licencePlate, Mileage mileage) {
        this.licencePlate = licencePlate;
        this.mileage = mileage;
        validate();
    }

    @Override
    protected void validate() {
        if (licencePlate == null) {
            throw new IllegalArgumentException("licencePlate is required");
        }
        if (mileage == null) {
            throw new IllegalArgumentException("kilometerstand is required");
        }
    }

    public LicensePlate getLicencePlate() {
        return licencePlate;
    }

    public Mileage getMileage() {
        return mileage;
    }
}
