package de.arkem.clean.arc.demo.app.lab.a.vehicle.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehicleMotionDataTest {

    @Test
    void shouldCreateVehicleMotionDataValueObject() {
        LicensePlate licensePlate = new LicensePlate("ES-EL 0815");
        VehicleMotionData vehicleMotionData = new VehicleMotionData(licensePlate);
        assertEquals(licensePlate, vehicleMotionData.licensePlate());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullLicensePlate() {
        assertThrows(IllegalArgumentException.class, () -> new VehicleMotionData(null));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToInvalidLicensePlate() {
        assertThrows(IllegalArgumentException.class, () -> new VehicleMotionData(new LicensePlate("ES_EL 0815")));
    }
}