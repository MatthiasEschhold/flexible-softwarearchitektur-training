package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageUnit;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageValue;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.MileageComparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MileageComparatorTest {

    MileageComparator comparatorToTest;
    @BeforeEach
    void setUp() {
        comparatorToTest = new MileageComparator();
    }
    @Test
    void compare() {

        Mileage mileage1 = new Mileage(MileageUnit.MILES, new MileageValue(100.0));
        Mileage mileage2 = new Mileage( MileageUnit.MILES, new MileageValue(100.0));
        Mileage mileage3 = new Mileage(MileageUnit.KM, new MileageValue(100.0));

        assertEquals(0, comparatorToTest.compare(mileage1, mileage2));
    }
}