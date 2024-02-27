# Aufgabe 1 Domänenmodell Vehicle

## Lernziele

- Stereotyp Value Object verstehen und anwenden können
- Stereotyp Root Entity verstehen und anwenden können
- Fundament des Entities Ring / Domain Hexagon verstehen

## Aufgabe 1.1 Grundstruktur Root Entity Vehicle

1) Implementiere das Domänenmodell der Root Entity Vehicle wie dargestellt auf Folie 38 / Seite 35 im PDF
2) Erstelle das Package <i>vehicle.domain.model</i> und lege die Domänenobjekte in diesem Package ab
3) Implementiere die im folgenden aufgeführten Validierungsregeln in den betroffenen Domänenobjekten

 ![Vehicle Domain Model](../img/vehicle-domain-model.png)
 Abb 1: Vehicle Domain Model

| Domänenobjekt               | Validierungsregel                                                            |
|-----------------------------|------------------------------------------------------------------------------|
| Vehicle                     | Die Eigenschaften Vin, LicensePlate und Mileage müssen immer vorhanden sein. |
| VIN                         | Ein valider Wert muss dem vorgesehenen Pattern folgen.                       |
| LicensePlate                | Ein valider Wert muss dem vorgesehenen Pattern folgen.                       |
| Mileage                     | Der Kilometerstand muss größer 0 sein.                                       |
| EquipmentCode               | Ein valider Wert muss dem vorgesehenen Pattern folgen.                       |
| CountryOfManufacture        | Ein valider Wert muss dem vorgesehenen Pattern folgen.                       |
| Alle anderen Domänenobjekte | Kein Nullwerte, keine leeren oder blank Strings.                             |


### Regex Pattern für das Value Object Vin

Beispiele:
1) WP0ZZZ99ZTS392155
2) WBAOLZ99ZTS349156

 ```java
 "(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}"
 ```
   
### Regex Pattern für das Value Object LicensePlate
   
Beispiele:
1) B-AB 123
2) ES-CD 456

```java
"^[A-Z0-9]{1,7}$"
```

### Regex Pattern für das Value Object CountryOfManufacture

Beispiele:
1) US
2) DE

```java
"^[A-Z]{2}$"
```

## Aufgabe 1.2 Rich Domain Model - Verhalten am Domänenobjekt

Implementiere die Aktualisierung des Kilometerstandes (Mileage) mit Plausibilitätsprüfung.

### Plausibilitätsprüfung für den Kilometerstand

```java
mew milegae > previous mileage
```