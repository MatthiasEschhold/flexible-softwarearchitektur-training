# Aufgabe 5 Fachliche Modularisierung anhand Root Entities 

## Lernziele

- Fachliche Modularisierung anhand von Root Entities verstehen und anwenden können
- Erfahren, wie das System in der Clean Architecture wächst und erweitert wird
- Strategien für die Behandlung von Abhängigkeiten zwischen Root Entities verstehen

## Aufgabe 5.1 Anwendungsfall Werkstattauftrag anlegen

1) Für die Anlage eines Werkstattauftrags werden **ein Teil** der Fahrzeugdaten benötigt
2) Die Abfrage muss anhand des Kennzeichens oder auch Fahrgestellnummer möglich sein
3) Implementiere ein Muster deiner Wahl, um diese Abhängigkeit zwischen Root Entites zu implementieren

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

## Aufgabe 5.2 Anwendungsfall Kunde und Fahrzeug verknüpfen 

1) In der Kundenverwaltung wird ein Fahrzeug nach Anlage mit dem Kunden verknüpft
2) Diese Zuordnung wird anhand des Kennzeichens und der Fahrgestellnummer am Kundenobjekt durchgeführt
3) Implementiere ein Muster deiner Wahl, um diese Abhängigkeit zwischen Root Entites zu implementieren

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin                      |
| Rückgabe              | Vehicle Data      |


| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | LicensePlate             |
| Rückgabe              | Vehicle Data             |

#### Fahrzeugdaten die am Kundenobjekt benötigt werden

```java
VehicleData {
    licensePlate: String
    vin: String    
}
```

### Ablauf des Anwendungsfalls

Abfrage der Fahrzeugstammdaten aus der eigenen Datenbank