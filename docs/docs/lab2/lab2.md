# Aufgabe 2 Anwendungsfälle der Root Entity Vehicle

## Lernziele

- Stereotyp Use Case Input Port verstehen und anwenden können
- Stereotyp Use Case Output Port verstehen und anwenden können
- Stereotyp Interactor verstehen und anwenden können
- Aufgaben des Use Cases Ring / Application Hexagon verstehen

## Aufgabe 2.0 Basisstruktur des Use Cases Ring anlegen

- Erstelle das Package _vehicle.usecase.in_
- Erstelle das Package _vehicle.usecase.out_
- Erstelle das Package _vehicle.usecase.interactor_

## Aufgabe 2.1 Anwendungsfall Fahrzeug anlegen

- Erstelle die notwendigen ein- und ausgehenden Use Case für die Fahrzeuganlage
- Erstelle den Use Case Interactor des Anwendungsfalls
- Leg die Klassen in den entsprechenden Packages ab
- Erstelle einen Unit-Test für den Interactor

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte             |
|-----------------------|----------------------------|
| Parameter             | Vin, LicensePlate, Mileage |
| Rückgabe              | Vehicle                    |

### Ablauf des Anwendungsfalls

- Abfrage der Fahrzeugstammdaten bei einem externen Service anhand der Vin
- Erstellung des Fahrzeugs
- Speichern der Fahrzeugdaten in der Datenbank

> Scope beachten! Use Cases Ring!

### Beispiel für ein Test mit Mockito

```java
package de.arkem.clean.arc.demo.app.lab.aufgabe2.vehicle.usecase.interactor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CreateVehicleInteractorTest {
    
    private static final String VIN_TEST_VALUE = "WP0ZZZ99ZTS392155";
    private static final String LICENSE_PLATE_TEST_VALUE = "ES-EL 0815";
    private static final double MILEAGE_TEST_VALUE = 1000;
    
    CreateVehicleInteractor interactorUnderTest;
    
    SaveVehicle saveVehicle = Mockito.mock(SaveVehicle.class);
    FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
    FetchRiskCountries fetchRiskCountries = Mockito.mock(FetchRiskCountries.class);
    DetectTheftStatus detectTheftStatus = Mockito.mock(DetectTheftStatus.class);
    TheftRiskRatingService theftRiskRatingService = Mockito.mock(TheftRiskRatingService.class);
    
    @BeforeEach
    void setUp() {
        interactorUnderTest = new CreateVehicleInteractor(saveVehicle, fetchVehicleMasterData, fetchRiskCountries, detectTheftStatus, theftRiskRatingService);
    }

    @Test
    void shouldCreateANewVehicle() {
        var licensePlate = new LicensePlate(LICENSE_PLATE_TEST_VALUE);
        var vin = new Vin(VIN_TEST_VALUE);
        var mileage = new Mileage(MILEAGE_TEST_VALUE);
        var vehicleMasterData = getVehicleMasterData();
        var savedVehicle = new Vehicle(vin, licensePlate, mileage, vehicleMasterData);

        when(fetchVehicleMasterData.fetchVehicleMasterData(any(Vin.class))).thenReturn(vehicleMasterData);
        when(saveVehicle.save(any(Vehicle.class))).thenReturn(savedVehicle);
        when(fetchRiskCountries.fetch()).thenReturn(Arrays.asList(new RiskCountry("DE"), new RiskCountry("FR")));
        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new TheftStatus("NOT_STOLEN"));

        var vehicle = interactorUnderTest.create(vin, licensePlate, mileage);

        assertThat(vehicle.getVin(), equalTo(vin));
        assertThat(vehicle.getLicensePlate(), equalTo(licensePlate));
    }

    @Test
    void shouldThrowExceptionDueToStolenVehicle() {
        var licensePlate = new LicensePlate(LICENSE_PLATE_TEST_VALUE);
        var vin = new Vin(VIN_TEST_VALUE);
        var mileage = new Mileage(MILEAGE_TEST_VALUE);
        var vehicleMasterData = getVehicleMasterData();

        when(fetchVehicleMasterData.fetchVehicleMasterData(any(Vin.class))).thenReturn(vehicleMasterData);
        when(fetchRiskCountries.fetch()).thenReturn(Arrays.asList(new RiskCountry("DE"), new RiskCountry("FR")));
        when(detectTheftStatus.detect(any(Vin.class))).thenReturn(new TheftStatus("STOLEN"));

        assertDoesNotThrow(()  -> interactorUnderTest.create(vin, licensePlate, mileage));

    }

    private VehicleMasterData getVehicleMasterData() {
        return new VehicleMasterData(new CountryOfManufacture("DE"),
                Arrays.asList(new Equipment(new EquipmentCode("1234"), new EquipmentLabel("Test Equipment"))));
    }
}
```

## Aufgabe 2.2 Anwendungsfall Kilometerstand aktualisieren

- Erstelle die notwendigen ein- und ausgehenden Use Case für die Fahrzeuganlage
- Erstelle den Use Case Interactor des Anwendungsfalls
- Leg die Klassen in den entsprechenden Packages ab
- Erstelle einen Unit-Test für den Interactor

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin, Mileage             |
| Rückgabe              | void                     |

### Ablauf des Anwendungsfalls

- Auslesen des Fahrzeugs aus der Datenbank anhand der Vin 
- Aktualisierung mit Plausibilitätsprüfung des Kilometerstandes
- Speichern des Fahrzeugs in der Datenbank

## Aufgabe 2.3 Erweiterung des Anwendungsfalls Fahrzeuganlage mit Risikobewertung und Diebstahlstatus

- Bei der Fahrzeuganlage ist eine Risikobewertung sowie die Abfrage des Diebstahlstatus notwendig
- Für die Risikobewertung sind Risikoländer relevant, die von einem externen Service abgefragt werden
- Entscheide dich für einen Use-Case-Schnitt und implementiere diesen
- Wird ein Risiko-Score von X ermittelt, muss eine Diebstahlstatusabfrage bei Interpol erfolgen
- Erstelle das Package _vehicle.domain.service_ und erstelle den Domain Service für die Ermittlung des Risikoscores
- Welche neuen Domänenobjekte werden benötigt und wie können diese im Package-Baum eingeordnet werden?
- Erweitere den Unit-Test für den CreateVehicleInteractor
- Schreibe einen Unit-Test für den Domain Service

## Risikobewertung

- Hatte das Fahrzeug einen nachvollziehbaren Grenzübergang (countryOfManufacture != registrationCountry)
- Ist das Fahrzeug in einem Risikoland angemeldet

#### Hilfsmethode zur Ermittlung des Registrierungslandes anhand des Kennzeichens
```java
public TheftStatusRequestResponse {
    private String vin;
    private boolean stolen;
}
```

### Schnittstellenbeschreibung Risikoländer

| Schnittstellenelement | Domänenobjekte      |
|-----------------------|---------------------|
| Parameter             | Keine               |
| Rückgabe              | List of RiskCountry |

### Schnittstellenbeschreibung Diebstahlstatusabfrage Interpol

| Schnittstellenelement | Domänenobjekte |
|-----------------------|----------------|
| Parameter             | Vin            |
| Rückgabe              | TheftStatus    |

#### Response der Diebstahlabfrage
```java
public TheftStatusRequestResponse {
    private String vin;
    private boolean stolen;
}
```

### Ablauf des Anwendungsfalls

- Ermittlung des Risikoscores anhand der Risikoländer (RiskCountries), Kennzeichen (LicensePlate)
- Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin
- Bei einem Risikoscore > 20 erfolgt die Abfrage des Diebstahlstatus bei Interpol 
- Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin 
- Erstellung des Fahrzeugs
- Speichern der Fahrzeugdaten in der Datenbank
