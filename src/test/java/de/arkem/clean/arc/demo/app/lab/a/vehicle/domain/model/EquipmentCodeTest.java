package de.arkem.clean.arc.demo.app.lab.a.vehicle.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EquipmentCodeTest {
    @Test
    void shouldCreateValidEquipmentCode() {
        String code = "AB1234";
        assertEquals(code, new EquipmentCode(code).value());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentCode(""));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToBlankString() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentCode(" "));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new EquipmentCode("AAB1234"));
    }

}