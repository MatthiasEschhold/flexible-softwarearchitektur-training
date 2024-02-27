# Aufgabe 2 Anwendungsfälle der Root Entity Vehicle

## Lernziele

- Stereotyp Use Case Input Port verstehen und anwenden können
- Stereotyp Use Case Output Port verstehen und anwenden können
- Stereotyp Interactor verstehen und anwenden können
- Aufgaben des Use Cases Ring / Application Hexagon verstehen

## Aufgabe 2.0 Basisstruktur des Use Cases Ring anlegen

1) Erstelle das Package _vehicle.usecase.in_
2) Erstelle das Package _vehicle.usecase.out_
3) Erstelle das Package _vehicle.usecase.interactor_

## Aufgabe 2.1 Anwendungsfall Fahrzeug anlegen

1) Erstelle die notwendigen ein- und ausgehenden Use Case für die Fahrzeuganlage
2) Erstelle den Use Case Interactor des Anwendungsfalls
3) Leg die Klassen in den entsprechenden Packages ab

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte             |
|-----------------------|----------------------------|
| Parameter             | Vin, LicensePlate, Mileage |
| Rückgabe              | Vehicle                    |

### Ablauf des Anwendungsfalls


1) Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin
2) Erstellung des Fahrzeugs
2) Speichern der Fahrzeugdaten in der Datenbank

> Scope beachten! Use Cases Ring!

## Aufgabe 2.2 Anwendungsfall Kilometerstand aktualisieren

1) Erstelle die notwendigen ein- und ausgehenden Use Case für die Fahrzeuganlage
2) Erstelle den Use Case Interactor des Anwendungsfalls
3) Leg die Klassen in den entsprechenden Packages ab

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin, Mileage             |
| Rückgabe              | void                     |

### Ablauf des Anwendungsfalls

1) Auslesen des Fahrzeugs aus der Datenbank anhand der Vin
2) Aktualisierung mit Plausibilitätsprüfung des Kilometerstandes
3) Speichern des Fahrzeugs in der Datenbank
