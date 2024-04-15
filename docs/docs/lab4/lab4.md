# Aufgabe 4 Weitere Anwendungsfälle der Root Entity Vehicle

## Lernziele

- Strategie für den Use Case Schnitt verstehen und anwenden können
- Erfahren, wie das Modul in der Clean Architecture wächst und erweitert wird
- Einsatzmöglichkeit Full Mapping Strategie verstehen

## Aufgabe 4.0 Mapping Strategie

Verwende die Two-Way oder Full Mapping Strategie für das Mapping der Data Transfer Objects und der Domänenobjekte in 
den Aufgaben 4.1 und 4.2.


## Aufgabe 4.1 Anwendungsfall Abfrage der Fahrzeugdaten für das eigene Frontend

- Das Frontend benötigt Fahrzeugdaten für die Anzeige
- Entscheide dich für einen Use-Case-Schnitt und implementiere den Anwendungsfall inklusive Interactor, Interfaces Adapters und Data Transfer Objects

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte         |
|-----------------------|------------------------|
| Parameter             | Vin                    |
| Rückgabe              | Vehicle     |

### Ablauf des Anwendungsfalls

Abfrage der Fahrzeugdaten aus der eigenen Datenbank anhand der Vin

## Aufgabe 4.2 Anwendungsfall Fahrzeugstammdaten für externe Konsumenten

- Das System _Spare Parts Management_ benötigt Fahrzeugstammdaten für Ersatzteilbestellungen
- Entscheide dich für einen Use-Case-Schnitt und implementiere den Anwendungsfall inklusive Interactor, Interfaces Adapters und Data Transfer Objects
- Verwende die Two-Way Mapping Strategie für das Mapping der Data Transfer Objects und der Domänenobjekte

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin                      |
| Rückgabe              | Vehicle Master Data      |

### Ablauf des Anwendungsfalls
Abfrage der Fahrzeugstammdaten aus der eigenen Datenbank anhand der Vin
