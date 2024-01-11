package de.arkem.clean.arc.demo.app.lab.a.vehicle.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VinTest {

    private final static List<String> VALID_VIN_LIST = Arrays.asList(
            "KMHDU4ADXAU832403", //2010 Hyundai Elantra
            "1GCHC33N7RJ376544", //1994 Chevrolet C/K 3500
            "2S3TD52V3Y6103456", //2000 Suzuki Esteem
            "1G1ZT51816F264066", //2006 Chevrolet Malibu
            "1GBJK34G32E254979" //2002 Chevrolet Silverado 3500
    );

    private final static List<String> INVALID_VIN_LIST = Arrays.asList(
            null,
            "",
            " ",
            "K 234 Lm",
            "123445667",
            "WERTTZUUKHGH"
    );

    @Test
    void shouldCreateValidVinValueObject() {
        VALID_VIN_LIST.forEach(vin -> assertDoesNotThrow(() -> new Vin(vin)));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionDueToInvalidVinValue() {
        INVALID_VIN_LIST.forEach(vin -> assertThrows(IllegalArgumentException.class, () -> new Vin(vin)));
    }
}