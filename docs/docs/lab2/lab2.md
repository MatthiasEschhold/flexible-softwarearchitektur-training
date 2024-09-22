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
- Erstelle den Use Case Interactor des Anwendungsfalls "Fahrzeug anlegen"
- Leg die Klassen in die entsprechenden Packages ab
- Erstelle einen Unit-Test für den Interactor

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte             |
|-----------------------|----------------------------|
| Parameter             | Vin, LicensePlate, Mileage |
| Rückgabe              | Vehicle                    |

### Ablauf (Flow of Control) des Anwendungsfalls (Happy Path)

- Abfrage der Fahrzeugstammdaten bei einem externen Service anhand der Vin
- Erstellung des Fahrzeugs
- Speichern der Fahrzeugdaten

> Scope beachten! Use Cases Ring!

### Beispiel für ein Test mit Mockito
    
```java
//...
```

## Aufgabe 2.2 Anwendungsfall Kilometerstand aktualisieren

- Erstelle die notwendigen ein- und ausgehenden Use Case für die Kilometerstandaktualisierung
- Erstelle den Use Case Interactor des Anwendungsfalls
- Leg die Klassen in die entsprechenden Packages ab
- Erstelle einen Unit-Test für den Interactor

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin, Mileage             |
| Rückgabe              | void                     |

### Ablauf (Flow of Control) des Anwendungsfalls (Happy Path)

- Auslesen des Fahrzeugs aus der Datenbank anhand der Vin 
- Plausibilitätsprüfung der Kilometerstandsmeldung
- Aktualisierung des Kilometerstands im Domänenobjekt
- Speichern des Fahrzeugs

## Aufgabe 2.3 Erweiterung des Anwendungsfalls Fahrzeuganlage mit Risikobewertung und Diebstahlstatus

### Beschreibung

- Bei der Fahrzeuganlage ist eine Risikobewertung sowie die Abfrage des Diebstahlstatus notwendig
- Für die Risikobewertung sind Risikoländer relevant. Diese werden von einem externen Service bezogen
- Wird ein Risiko-Score von > 20 ermittelt, muss eine Diebstahlstatusabfrage bei Interpol erfolgen

#### Ermittlung des RiskScore

- Hatte das Fahrzeug einen nachvollziehbaren Grenzübergang (countryOfManufacture != registrationCountry)? Wenn ja: +10
- Ist das Fahrzeug in einem Risikoland angemeldet? Wenn ja: +20 Punkte

### Aufgabe

- Entscheidung: Welchen Use-Case-Schnitt setzt du für die ausgehenden Anwendungsfälle ein? Begründe deine Entscheidung!
- Erstelle das Package _vehicle.domain.service_ und erstelle den DomainService für die Ermittlung des Risikoscore
- Welche neuen Domänenobjekte werden benötigt und wie können diese im Package-Baum eingeordnet werden? (Alles erlaubt - Renaming, Verschieben, neues Packages, etc.)
- Erweitere den Unit-Test für den Interactor des Anwendungsfalls "Fahrzeug anlegen"
- Schreibe einen Unit-Test für den DomainService

### Ablauf (Flow of Control) des Anwendungsfalls (Happy Path)

- Ermittlung des Risikoscore anhand der Risikoländer (RiskCountries), Kennzeichen (LicensePlate)
- Bei einem Risikoscore > 25 erfolgt die Abfrage des Diebstahlstatus bei Interpol
- Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin
- Erstellung des Fahrzeugs
- Speichern der Fahrzeugdaten

### Externe Schnittstellen

#### Schnittstellenbeschreibung Risikoländer

| Schnittstellenelement | Domänenobjekte      |
|-----------------------|---------------------|
| Parameter             | Keine               |
| Rückgabe              | List of RiskCountry |

#### Schnittstellenbeschreibung Diebstahlstatusabfrage Interpol

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

### Hilfestellung für die Implementierung

#### Methode zur Ermittlung des Risikoscores auf dem Kennzeichen

```java
public String getRegistrationCountry(String licensePlate) {
    // magic...
    return new RegistrationCountry("DE");
}
```