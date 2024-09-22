# Aufgabe 3 Implementierung der Interface Adapters

## Lernziele

- Meta-Stereotyp Interface Adapter verstehen
- Beispiele für Stereotypen von Interface Adapters verstehen und anwenden können
- Aufgaben und Konzepte des Interface Adapters Ring / Adapters Hexagon verstehen

## Aufgabe 3.0 Basisstruktur des Interace Adapters Ring anlegen

- Erstelle das Package _vehicle.adapter.in_
- Erstelle das Package _vehicle.adapter.out_

## Aufgabe 3.1 Implementierung der Interface Adapters

> Die Interface Adapters solle die Integration der technischen Komponenten nur andeuten!
> Fokus liegt auf der Implementierung der Use Cases, der eingesetzten Designkonzepte und der Adaption mittels Mapping.

| Anwendungsfall               | Eingehende Interface Adapter | Technische Komponente |
|------------------------------|------------------------------|-----------------------|
| Fahrzeug anlegen             | Controller                   | Web                   |
| Kilometerstand aktualisieren | Controller                   | Web                   |

| Anwendungsfall             | Ausgehende Interface Adapter | Technische Komponente |
|----------------------------|------------------------------|-----------------------|
| Fahrzeug speichern         | Repository                   | Datenbank             |
| Fahrzeug lesen             | Repository                   | Datenbank             |
| Risikoländer abfragen      | ServiceClient                | Externe REST API      |
| Abfrage Diebstahlstatus    | ServiceClient                | Externe REST API      |
| Abfrage Fahrzeugstammdaten | ServiceClient                | Externe REST API      |  


- Implementiert die Interface Adapters und deren Datentransferobjekte für die Anwendungsfälle Fahrzeug anlegen und Kilometerstand aktualisieren sowie die für die sich daraus ergebenden ausgehenden Anwendungsfälle
- Verwende die Two-Way Mapping Strategie
- Implementiere keine Tests für die Interface Adapters
- Optional: 
  - Wende die One-Way Mapping Strategie im Interface Adapter des Anwendungsfall "Kilometerstand aktualisieren" an
    - Was hälst du davon? Wie empfindest du die Mischung der Strategien und Auswirkung auf die Domänenobjekte
  - Wende die No Mapping Strategie im Interface Adapter des Anwendungsfall "Fahrzeug speichern" und "Fahrzeug lesen" an
    - Was hälst du davon? Wie empfindest du die Mischung der Strategien und Auswirkung auf die Domänenobjekte
  - Verwende eine Mapping-Library deiner Wahl für das Mapping im ausgehenden Interface Adapter für die Abfrage der Fahrzeugstammdaten (siehe auch Aufgabe 3.2)

## Hilfestellung für die Implementierung

### Resource-Model der REST API

```java

public class VehicleResource {
    private String vin;
    private String licensePlate;
    private List<MileageRecordResource> mileageRecords;
    private VehicleMasterDataResource vehicleMasterData;

    public VehicleMasterDataResource getVehicleMasterData() {
        return vehicleMasterData;
    }

    public void setVehicleMasterData(VehicleMasterDataResource vehicleMasterData) {
        this.vehicleMasterData = vehicleMasterData;
    }
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<MileageRecordResource> getMileageRecords() {
        return mileageRecords;
    }

    public void setMileageRecords(List<MileageRecordResource> mileageRecords) {
        this.mileageRecords = mileageRecords;
    }
}


```

```java

public class VehicleMasterDataResource {
    private List<EquipmentResource> equipmentList;
    private String countryOfManufacture;

    public List<EquipmentResource> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentResource> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public String getCountryOfManufacture() {
        return countryOfManufacture;
    }

    public void setCountryOfManufacture(String countryOfManufacture) {
        this.countryOfManufacture = countryOfManufacture;
    }
}

```

```java
public class MileageRecordResource {
    private String recordDate;
    private Double mileage;

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public Double getMileage() {
        return mileage;
    }

```

```java
public class EquipmentResource {

    private String equipmentCode;
    private String equipmentLabel;

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentLabel() {
        return equipmentLabel;
    }

    public void setEquipmentLabel(String equipmentLabel) {
        this.equipmentLabel = equipmentLabel;
    }
}

```

### Das Domänenmodell in der Datenbank


```java


public class VehicleDbEntity {

    private String vin;
    private String licensePlate;
    private List<MileageRecordDbEntity> mileageRecords;
    private List<EquipmentDbEntity> equipmentList;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<MileageRecord> getMileageRecords() {
        return mileageRecords;
    }

    public void setMileageRecords(List<MileageRecord> mileageRecords) {
        this.mileageRecords = mileageRecords;
    }

    public List<EquipmentDbEntity> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentDbEntity> equipmentList) {
        this.equipmentList = equipmentList;
    }
}

```

```java

public class EquipmentDbEntity {
    private String equipmentCode;
    private String equipmentLabel;

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentLabel() {
        return equipmentLabel;
    }

    public void setEquipmentLabel(String equipmentLabel) {
        this.equipmentLabel = equipmentLabel;
    }
}

```

```java
public class MileageRecordDbEntity {
    private double mileage;
    private String recordTime;

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }
}

```

## (Optional) 3.2 Analysiere den Einsatz von Mapping-Frameworks

- Welche Mapping-Frameworks gibt es?
- Welche Vor- und Nachteile haben die Frameworks?
- 
[Object-to-object mapping framework microbenchmark](https://github.com/arey/java-object-mapper-benchmark)
[MapStruct](https://mapstruct.org/)
[Orika](https://orika-mapper.github.io/orika-docs/)