package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.usecase.interactor.CreateVehicleInteractor;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.SaveVehicle;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateVehicleInteractorTest {
    CreateVehicleInteractor interactorUnderTest;
    SaveVehicle saveVehicle = Mockito.mock(SaveVehicle.class);
    FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);

    @BeforeEach
    void setUp() {
        interactorUnderTest = new CreateVehicleInteractor(saveVehicle, fetchVehicleMasterData);
    }

    @Test
    void shouldCreateANewVehicle() {
        var licensePlate = new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE);
        var vin = new Vin(VehicleTestDataFactory.VIN_TEST_VALUE);
        var mileage = new Mileage(VehicleTestDataFactory.MILEAGE_TEST_VALUE);
        var vehicleMasterData = VehicleTestDataFactory.createVehicleMasterData();

        var savedVehicle = new Vehicle(vin, licensePlate, mileage, vehicleMasterData);

        when(fetchVehicleMasterData.fetch(any(Vin.class))).thenReturn(vehicleMasterData);
        when(saveVehicle.save(any(Vehicle.class))).thenReturn(savedVehicle);

        var vehicle = interactorUnderTest.create(vin, licensePlate, mileage);

        assertThat(vehicle.getVin(), equalTo(vin));
        assertThat(vehicle.getLicensePlate(), equalTo(licensePlate));
    }
}