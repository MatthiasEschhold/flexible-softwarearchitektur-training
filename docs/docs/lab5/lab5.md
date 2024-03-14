# Aufgabe 5 Fachliche Modularisierung anhand Root Entities 

## Lernziele

- Fachliche Modularisierung anhand von Root Entities verstehen und anwenden können
- Erfahren, wie das System in der Clean Architecture wächst und erweitert wird
- Strategien für die Behandlung von Abhängigkeiten zwischen Root Entities verstehen

## Aufgabe 5.1 Anwendungsfall Werkstattauftrag anlegen

- Für die Anlage eines Werkstattauftrags werden **ein Teil** der Fahrzeugdaten benötigt
- Die Abfrage muss anhand des Kennzeichens oder auch Fahrgestellnummer möglich sein
- Implementiere ein Muster deiner Wahl, um diese Abhängigkeit zwischen Root Entites zu implementieren

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin                      |
| Rückgabe              | Vehicle Data      |


| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | LicensePlate             |
| Rückgabe              | Vehicle Data             |

#### Fahrzeugdaten die im Werkstattauftrag benötigt werden

```java
VehicleData {
    licensePlate: String
    vin: String
    mileage: double        
}
```

### Ablauf des Anwendungsfalls

Abfrage der Fahrzeugstammdaten aus der eigenen Datenbank

## Aufgabe 5.2 Anwendungsfall Fahrzeugstammdaten abfragen für Ersatzteilebestellungen

- Der Ersatzteilbestellprozess benötigt Fahrzeugstammdaten
- Implementiere ein Muster deiner Wahl, um diese Abhängigkeit zwischen Root Entites zu implementieren
- Diskutiere / Überlege, wann ein Shared Output Adapter Pattern oder Supporting Service Pattern eine alternative sein kann, und wann welches Muster besser geeignet ist

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte    |
|-----------------------|-------------------|
| Parameter             | Vin               |
| Rückgabe              | VehicleMasterData |

### Ablauf des Anwendungsfalls

Abfrage der Fahrzeugstammdaten aus der eigenen Datenbank