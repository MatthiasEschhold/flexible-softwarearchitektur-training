package de.arkem.clean.arc.demo.app.lab.d.interactor;

import de.arkem.clean.arc.demo.app.lab.b.vehicle.domain.model.*;
import de.arkem.clean.arc.demo.app.lab.b.vehicle.usecase.interactor.VehicleService;
import de.arkem.clean.arc.demo.app.lab.b.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.clean.arc.demo.app.lab.b.vehicle.usecase.out.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class VehicleCommandServiceTest {
    public static final String VIN_TEST_VALUE = "WP0ZZZ99ZTS392155";
    VehicleService serviceUnderTest;
    @Mock
    VehicleRepository repository;
    @Mock
    FetchVehicleMasterData fetchVehicleMasterData;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(VehicleRepository.class);
        fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
        serviceUnderTest = new VehicleService(repository, fetchVehicleMasterData);
    }

    @Test
    void shouldCreateVehicle() {
        VehicleMotionData vehicleMotionData = new VehicleMotionData(new LicensePlate("ES-EL 0815"));
        VehicleMasterData vehicleMasterData = new VehicleMasterData(Arrays.asList(new Equipment(new EquipmentCode("SH0815"), new EquipmentLabel("Standheizung"))));
        Vehicle expectedVehicle = new Vehicle(new Vin(VIN_TEST_VALUE), vehicleMotionData, vehicleMasterData);
        when(repository.save(any(Vehicle.class))).thenReturn(expectedVehicle);
        when(fetchVehicleMasterData.fetch(any(Vin.class))).thenReturn(vehicleMasterData);
        Vehicle actualVehicle = serviceUnderTest.createVehicle(new Vin(VIN_TEST_VALUE), vehicleMotionData);
        assertThat(actualVehicle).isEqualTo(expectedVehicle);
    }
}