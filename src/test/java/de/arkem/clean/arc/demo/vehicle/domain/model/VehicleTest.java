package de.arkem.clean.arc.demo.vehicle.domain.model;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.Mileage;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehicleTest {
    @Test
    void shouldUpdateMileageWithHigherValue() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        vehicle.updateMileage(new Mileage(3000.01));
        assertThat(vehicle.getMileageRecords(), hasSize(4));
    }


    @Test
    void shouldUpdateMileageWithSameValue() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        vehicle.updateMileage(new Mileage(3000.00));
        assertThat(vehicle.getMileageRecords(), hasSize(4));
    }

    @Test
    void shouldThrowExceptionDueToLowerMilegageThanThePrevious() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        assertThrows(IllegalArgumentException.class, () -> vehicle.updateMileage(new Mileage(2999.99)));
    }

    @Test
    void createNewVehicle() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        assertThat(vehicle.getMileageRecords(), hasSize(3));
    }

    @Test
    void shouldFindLatestMileageWithValue3000() {
        Vehicle vehicle = VehicleTestDataFactory.createVehicle();
        assertThat(vehicle.findLatestMileage().isPresent(), is(true));
        assertThat(vehicle.findLatestMileage().get(), is(equalTo(new Mileage(3000))));
    }

    @Test
    void shouldReturnEmptyOptionalForFindLatestMileage() {
        Vehicle vehicle = new Vehicle(new Vin(VehicleTestDataFactory.VIN_TEST_VALUE),
                new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE), new ArrayList<>());
        assertThat(vehicle.findLatestMileage().isPresent(), is(false));
    }

}