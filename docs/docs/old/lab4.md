# Weitere Designprinzipen

## Encapsulation und Lesbarkeit durch Command Objekte

## Erweiterung des Domänenmodell Mileage und Mileage History

### Anwendungsfall Update Mileage mit Plausibilitätsprüfung

<details>
<summary>Coding Task 5</summary>

<details>
<summary>Implementiere die Abfrage von Fahrzeudaten anhand der Vin</summary>
<li>Führe den eingehenden Use Case <i>VehicleQuery</i> mit der Schnittstelle wie unten beschrieben ein.</li>
<li>Erweitere den ausgehenden Use Case <i>VehicleRepository<i/> um die Schnittstelle wie unten beschrieben.</li>
<li>Implementiere den eingehenden Use Case im <i>VehicleService</i></li>
</details>

<details>
 <summary>Schnittstelle VehicleQuery</summary>

```java
Vehicle findByVin(Vin vin);
```
</details>

<details>
 <summary>Schnittstelle VehicleRepository</summary>

```java
VehicleMotionData findVehicleMotionDataByVin(Vin vin);
```
</details>
</details>
