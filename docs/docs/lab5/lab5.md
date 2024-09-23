# Aufgabe 5 Fachliche Modularisierung anhand Root Entities 

## Lernziele

- Fachliche Modularisierung anhand von Root Entities verstehen und anwenden können
- Erfahren, wie das System in der Clean Architecture wächst und erweitert wird
- Strategien für die Behandlung von Abhängigkeiten zwischen Root Entities verstehen

## Aufgabe 5.0 Fachliche Modularisierung

- Betrachte die Module GarageOrder und SpareParts

## Aufgabe 5.1 Anwendungsfall Werkstattauftrag anlegen

- Für die Anlage eines Werkstattauftrags im Modul GarageOrder werden die Vin, das Kennzeichen (LicensePlate) und der aktuelle Kilometerstand (Mileage) des Fahrzeugs benötigt
- Die Abfrage muss anhand des Kennzeichens oder der Fahrgestellnummer möglich sein
- Implementiere ein Muster deiner Wahl, um diese Abhängigkeit zwischen Root Entities / Modulen zu implementieren

### Schnittstellenbeschreibung Fahrzeugdaten abfragen

| Schnittstellenelement | Domänenobjekte |
|-----------------------|---------------|
| Parameter             | Vin           |
| Rückgabe              | VehicleData   |


| Schnittstellenelement | Domänenobjekte          |
|-----------------------|-------------------------|
| Parameter             | LicensePlate            |
| Rückgabe              | VehicleData             |

#### Fahrzeugdaten die im Werkstattauftrag benötigt werden

```java
VehicleData {
    licensePlate: String
    vin: String
    mileage: double        
}
```

### Ablauf des Anwendungsfalls

- Abfrage der Fahrzeugstammdaten aus der eigenen Datenbank

## Aufgabe 5.2 Anwendungsfall Fahrzeugstammdaten abfragen

- Die Ersatzteileverwaltung (Modul SpareParts) benötigt Fahrzeugstammdaten
- Implementiere ein Muster deiner Wahl, um diese Abhängigkeit zwischen Root Entities / Modulen zu implementieren
- 
### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte    |
|-----------------------|-------------------|
| Parameter             | Vin               |
| Rückgabe              | VehicleMasterData |

### Ablauf des Anwendungsfalls

- Abfrage der Fahrzeugstammdaten aus der eigenen Datenbank

## Aufgabe 5.3 Weitere Muster

- Diskutiere in der Gruppe oder analysiere für dich, wann ein Shared Output Adapter Pattern oder Supporting Service Pattern eine gute alternative sein kann