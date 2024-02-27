# Aufgabe 4 Weitere Anwendungsfälle der Root Entity Vehicle

## Lernziele

- Strategie für den Use Case Schnitt verstehen und anwenden können
- Erfahren, wie das Modul in der Clean Architecture wächst und erweitert wird
- Stereotyp Domain Service verstehen und anwenden können

## Aufgabe 4.1 Anwendungsfall Abfrage der Fahrzeugdaten für das eigene Frontend

1) Das Frontend benötigt Fahrzeugdaten für die Anzeige
2) Entscheide dich für einen Use-Case-Schnitt und implementiere den Anwendungsfall inklusive Interactor, Interfaces Adapters und Data Transfer Objects
3) Verwende die Two-Way Mapping Strategie für das Mapping der Data Transfer Objects und der Domänenobjekte

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte         |
|-----------------------|------------------------|
| Parameter             | Vin                    |
| Rückgabe              | Vehicle     |

### Ablauf des Anwendungsfalls

Abfrage der Fahrzeugdaten aus der eigenen Datenbank anhand der Vin

## Aufgabe 4.2 Anwendungsfall Fahrzeugstammdaten für externe Konsumenten

1) Das System _Spare Parts Management_ benötigt Fahrzeugstammdaten für Ersatzteilbestellungen
2) Entscheide dich für einen Use-Case-Schnitt und implementiere den Anwendungsfall inklusive Interactor, Interfaces Adapters und Data Transfer Objects
3) Verwende die Two-Way Mapping Strategie für das Mapping der Data Transfer Objects und der Domänenobjekte

### Schnittstellenbeschreibung

| Schnittstellenelement | Domänenobjekte           |
|-----------------------|--------------------------|
| Parameter             | Vin                      |
| Rückgabe              | Vehicle Master Data      |

### Ablauf des Anwendungsfalls

Abfrage der Fahrzeugstammdaten aus der eigenen Datenbank anhand der Vin

## Aufgabe 4.3 Erweiterung des Anwendungsfalls Fahrzeuganlage mit Risikobewertung und Diebstahlstatus

1) Bei der Fahrzeuganlage ist eine Risikobewertung sowie die Abfrage des Diebstahlstatus notwendig
2) Für die Risikobewertung sind Risikoländer relevant, die von einem externen Service abgefragt werden
3) Wird ein Risiko-Score von X ermittelt, muss eine Diebstahlstatusabfrage bei Interpol erfolgen
4) Entscheide dich für einen Use-Case-Schnitt und implementiere den Anwendungsfall inklusive Interactor, Interfaces Adapters und Data Transfer Objects
5) Wie könnte eine passende Fehlerbehandlung in diesem Anwendungsfall aussehen? Implementiere diese.
6) Welche neuen Domänenobjekte benötigst du für die Implementierung? Implementiere diese.

## Risikobewertung


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

```java
public enum TheftStatus {
    STOLEN, NOT_STOLEN, UNKNOWN
}
```

### Ablauf des Anwendungsfalls

1) Ermittlung des Risikoscores anhand der RiskCountries und LicensePlate
2) Bei einem Risikoscore > X Abfrage des Diebstahlstatus bei Interpol
3) Abfrage der Fahrzeugdaten bei einem externen Service anhand der Vin
4) Erstellung des Fahrzeugs
5) Speichern der Fahrzeugdaten in der Datenbank