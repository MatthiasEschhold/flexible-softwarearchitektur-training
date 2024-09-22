package de.arkem.clean.arc.demo.vehicle.usecase.interactor;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.CountryCode;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating.TheftStatus;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.mileage.record.Mileage;
import de.arkem.clean.arc.demo.app.vehicle.domain.service.TheftRiskRatingService;
import de.arkem.clean.arc.demo.app.vehicle.usecase.interactor.CreateVehicleInteractor;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.DetectTheftStatus;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FetchRiskCountries;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.vehicle.usecase.out.SaveVehicle;
import de.arkem.clean.arc.demo.vehicle.test.data.VehicleTestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CreateVehicleInteractorTest {
    CreateVehicleInteractor interactorUnderTest;
    SaveVehicle saveVehicle = Mockito.mock(SaveVehicle.class);
    FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
    TheftRiskRatingService theftRiskRatingService = Mockito.mock(TheftRiskRatingService.class);
    DetectTheftStatus detectTheftStatus = Mockito.mock(DetectTheftStatus.class);
    FetchRiskCountries fetchRiskCountries = Mockito.mock(FetchRiskCountries.class);

    @BeforeEach
    void setUp() {
        interactorUnderTest = new CreateVehicleInteractor(saveVehicle, fetchVehicleMasterData, theftRiskRatingService, detectTheftStatus, fetchRiskCountries);
    }

    @Test
    void shouldCreateANewVehicle() {
        var licensePlate = new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE);
        var vin = new Vin(VehicleTestDataFactory.VIN_TEST_VALUE);
        var mileage = new Mileage(VehicleTestDataFactory.MILEAGE_TEST_VALUE);
        var vehicleMasterData = VehicleTestDataFactory.createVehicleMasterData();
        var riskCountries = Arrays.asList(new CountryCode("DE"), new CountryCode("FR"));

        var savedVehicle = new Vehicle(vin, licensePlate, mileage, vehicleMasterData);

        when(fetchVehicleMasterData.fetch(any(Vin.class))).thenReturn(vehicleMasterData);
        when(fetchRiskCountries.fetch()).thenReturn(riskCountries);
        when(theftRiskRatingService.detectRiskScore(any(), any(), any())).thenReturn(49);

        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new TheftStatus(false));
        when(saveVehicle.save(any(Vehicle.class))).thenReturn(savedVehicle);

        var vehicle = interactorUnderTest.create(vin, licensePlate, mileage);

        verify(detectTheftStatus, never()).detect(any(Vin.class));
        assertThat(vehicle.getVin(), equalTo(vin));
        assertThat(vehicle.getLicensePlate(), equalTo(licensePlate));
    }

    @Test
    void shouldThrowIllegalStateException() {
        var licensePlate = new LicensePlate(VehicleTestDataFactory.LICENSE_PLATE_TEST_VALUE);
        var vin = new Vin(VehicleTestDataFactory.VIN_TEST_VALUE);
        var mileage = new Mileage(VehicleTestDataFactory.MILEAGE_TEST_VALUE);
        var vehicleMasterData = VehicleTestDataFactory.createVehicleMasterData();

        when(fetchVehicleMasterData.fetch(any(Vin.class))).thenReturn(vehicleMasterData);
        when(fetchRiskCountries.fetch()).thenReturn(Arrays.asList(new CountryCode("DE"), new CountryCode("FR")));
        when(theftRiskRatingService.detectRiskScore(any(), any(), any())).thenReturn(50);
        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new TheftStatus(true));
        when(saveVehicle.save(any(Vehicle.class))).thenReturn(VehicleTestDataFactory.createVehicle());

        verify(detectTheftStatus, never()).detect(any(Vin.class));
        assertThrows(IllegalStateException.class, () -> interactorUnderTest.create(vin, licensePlate, mileage));
    }
}