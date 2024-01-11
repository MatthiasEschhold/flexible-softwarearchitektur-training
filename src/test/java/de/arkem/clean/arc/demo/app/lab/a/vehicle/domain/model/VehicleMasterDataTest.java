package de.arkem.clean.arc.demo.app.lab.a.vehicle.domain.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehicleMasterDataTest {

    @Test
    void shouldCreateValidVehicleMasterDataValueObject() {
        List<Equipment> list = new ArrayList<>();
        list.add(createEquipment("AB1234", "test"));
        VehicleMasterData masterData = new VehicleMasterData(list);
        assertThat(masterData.equipmentList(), hasSize(1));
        assertThat(masterData.equipmentList(), contains(createEquipment("AB1234", "test")));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToEmptyEquipmentList() {
        assertThrows(IllegalArgumentException.class, () -> new VehicleMasterData(new ArrayList<>()));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToNullList() {
        assertThrows(IllegalArgumentException.class, () -> new VehicleMasterData(null));
    }

    private Equipment createEquipment(String code, String label) {
        return new Equipment(new EquipmentCode(code), new EquipmentLabel(label));
    }
}