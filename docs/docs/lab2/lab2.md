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

- Erstelle die notwendigen ein- und ausgehenden Use Cases für die Fahrzeuganlage
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
//...
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
- Erstelle das Package _vehicle.domain.service_ und erstelle den DomainService für die Ermittlung des Risikoscore
- Welche neuen Domänenobjekte werden benötigt und wie können diese im Package-Baum eingeordnet werden?
- Erweitere den Unit-Test für den CreateVehicleInteractor
- Schreibe einen Unit-Test für den DomainService

## Risikobewertung

- Hatte das Fahrzeug einen nachvollziehbaren Grenzübergang (countryOfManufacture != registrationCountry)
- Ist das Fahrzeug in einem Risikoland angemeldet

#### Hilfsmethode zur Ermittlung des Registrierungslandes anhand des Kennzeichens im DomainService

```java
public String getRegistrationCountry(String licensePlate) {
    // magic...
    return new RegistrationCountry("DE");
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

- Ermittlung des Risikoscore anhand der Risikoländer (RiskCountries), Kennzeichen (LicensePlate)
- Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin
- Bei einem Risikoscore > 20 erfolgt die Abfrage des Diebstahlstatus bei Interpol 
- Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin 
- Erstellung des Fahrzeugs
- Speichern der Fahrzeugdaten in der Datenbank
