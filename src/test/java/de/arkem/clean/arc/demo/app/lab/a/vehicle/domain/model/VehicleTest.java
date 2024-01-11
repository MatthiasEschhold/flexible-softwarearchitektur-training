package de.arkem.clean.arc.demo.app.lab.a.vehicle.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehicleTest {

    @Test
    void shouldCreateValidVehicleRootEntity() {
        Vin vin = new Vin("1GBJK34G32E254979");
        LicensePlate licensePlate = createLicensePlate();
        VehicleMasterData vehicleMasterData = createVehicleMasterData();
        VehicleMotionData vehicleMotionData = createVehicleMotionData();
        Vehicle vehicle = new Vehicle(vin, vehicleMotionData, vehicleMasterData);
        assertEquals(vehicle.getVin(), vin);
        assertEquals(vehicle.getVehicleMotionData().licensePlate(), licensePlate);
        assertThat(vehicle.getVehicleMasterData().equipmentList(), hasSize(1));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullVin() {
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new Equipment(new EquipmentCode("AB1234"), new EquipmentLabel("test")));
        VehicleMasterData vehicleMasterData = new VehicleMasterData(equipmentList);
        VehicleMotionData vehicleMotionData = createVehicleMotionData();
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(null, vehicleMotionData, vehicleMasterData));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullVehicleMotionData() {
        Vin vin = new Vin("1GBJK34G32E254979");
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new Equipment(new EquipmentCode("AB1234"), new EquipmentLabel("test")));
        VehicleMasterData vehicleMasterData = new VehicleMasterData(equipmentList);
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(vin, null, vehicleMasterData));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullVehicleMasterData() {
        Vin vin = new Vin("1GBJK34G32E254979");
        VehicleMotionData vehicleMotionData = createVehicleMotionData();
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(vin, vehicleMotionData, null));
    }


    private VehicleMotionData createVehicleMotionData() {
        return new VehicleMotionData(createLicensePlate());
    }

    private VehicleMasterData createVehicleMasterData() {
        return new VehicleMasterData(createEquipmentList());
    }

    private List<Equipment> createEquipmentList() {
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new Equipment(new EquipmentCode("AB1234"), new EquipmentLabel("test")));
        return equipmentList;
    }

    private LicensePlate createLicensePlate() {
        return new LicensePlate("ES-EL 0815");
    }
}