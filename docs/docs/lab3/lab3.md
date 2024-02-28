# Aufgabe 3 Implementierung der Interface Adapters

## Lernziele

- Meta-Stereotyp Interface Adapter verstehen
- Beispiele für Stereotypen von Interface Adapters verstehen und anwenden können
- Aufgaben und Konzepte des Interface Adapters Ring / Adapters Hexagon verstehen

## Aufgabe 3.0 Basisstruktur des Interace Adapters Ring anlegen

- Erstelle das Package _vehicle.adapter.in_
- Erstelle das Package _vehicle.adapter.out_

## Aufgabe 3.1 Anwendungsfall Fahrzeug anlegen

> Die Interface Adapters solle die Integration der technischen Komponenten nur andeuten!
> Fokus liegt auf der Implementierung der Use Cases, der eingesetzten Designkonzepte und der Adaption mittels Mapping.

- Der Anwendungsfall wird durch eine REST API für das eigene JavaScript-Frontend exponiert
- Es wird eine relationale Datenbank für die Persistenz verwendet
- Es wird ein REST-Service für die Abfrage der Fahrzeugdaten verwendet
- Erstellt die notwendigen Interfaces Adapters und Data Transfer Objects
- Verwende die Two-Way Mapping Strategie für das Mapping der Data Transfer Objects und der Domänenobjekte

## Aufgabe 3.2 Anwendungsfall Kilometerstand aktualisieren

> Aufbauend auf Aufgabe 3.1

- Der Anwendungsfall wird durch eine REST API für das eigene JavaScript-Frontend exponiert
- Erstellt die (noch weiter) notwendigen Interfaces Adapters und Data Transfer Objects
- Verwende die Two-Way Mapping Strategie für das Mapping der Data Transfer Objects und der Domänenobjekte, falls weitere Mappings notwendig sind

## 3.3 Analysiert den Einsatz von Mapping-Frameworks

- Welche Mapping-Frameworks gibt es?
- Welche Vor- und Nachteile haben die Frameworks?

[MapStruct](https://mapstruct.org/)
[Orika](https://orika-mapper.github.io/orika-docs/)