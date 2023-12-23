package de.arkem.clean.arc.demo.app.lab.one.vehicle.domain.model;

import de.arkem.clean.arc.demo.app.lab.one.vehicle.domain.model.LicensePlate;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LicensePlateValueObjectTest {

    @Test
    public void shouldCreateValidLicensePlateValueObjects() {
        // Sample list of strings
        List<String> stringList = Arrays.asList("ES-EL 385", "ES-L 1385", "E-L 12");
        List<LicensePlate> licensePlateList = createLicensePlateValueObjects(stringList);

        assertThat(licensePlateList, Matchers.hasSize(3));
        assertThat(licensePlateList, everyItem(hasValueInList(stringList)));
    }

    @Test
    public void shouldThrowExceptionByTheCreationOfLicensePlateValueObject() {
        // Sample list of strings
        List<String> stringList = Arrays.asList("HalloWelt", "ESEL 123", "9989IKLOP");
        // Assert that creating LicensePlate objects and throwing an exception for each item
        for (String value : stringList) {
            assertThrows(IllegalStateException.class, () -> new LicensePlate(value));
        }
    }

    /**
     * Hamcrest could not handle records, due to this hasProperty("value", inList(stringList()) does not work
     * @param stringList
     * @return
     */
    private Matcher<LicensePlate> hasValueInList(List<String> stringList) {
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(LicensePlate licensePlate) {
                return stringList.contains(licensePlate.value());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("value should be in the list");
            }
        };
    }

    private List<LicensePlate> createLicensePlateValueObjects(List<String> stringList) {
        return stringList.stream()
                .map(LicensePlate::new)
                .toList();
    }
}
