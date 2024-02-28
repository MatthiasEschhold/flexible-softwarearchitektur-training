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

### Resource als DTO

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

### DB-Model als DTO


```java


public class VehicleDbEntity {

    private String vin;
    private String licensePlate;
    private List<MileageRecord> mileageRecords;
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
    private String mileage;
    private String recordTime;

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
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