# Adapter Ring - Implementierung des Ports & Adapters Pattern

##  Input Adapter

<details>
   <summary>Coding Task 3</summary>

<b>Erstelle einen Input Adapter für den eingehenden Use Case</b>
<br/>
<ol>
<li>Erstelle das Package <i>adapter.in</i> als Subpackage von <i>vehicle</i> und erstelle den Interface Adapter <i>VehicleController</i></li>
<li>Implementiere die technische HTTP Schnittstelle zur Anlage eines Fahrzeugs und nutze hierfür den Use Case <i>VehicleCommand</i></li>
<li>Erstelle das DTO <i>VehicleResource</i> (siehe Vorlage) und ein Mapper (<i>VehicleWebMapper</i>) für das DTO</li>.
<li>Ignoriere Details des Frameworks und des REST Architekturstils bei der Implementierung</li>

</ol>

<details>
      <summary>VehicleResource</summary>

   ```java
public class VehicleResource {
    
    private String vin;
    private VehicleMotionDataResource vehicleMotionData;
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

    public VehicleMotionDataResource getVehicleMotionData() {
        return vehicleMotionData;
    }

    public void setVehicleMotionData(VehicleMotionDataResource vehicleMotionData) {
        this.vehicleMotionData = vehicleMotionData;
    }
}

   ```
</details>

</details>

## Output Adapter

<details>
   <summary>Coding Task 4</summary>

<b>Erstelle die Output Adapter für die ausgehenden Use Cases</b>
<br/>
<ol>
<li>Erstelle das Package <i>adapter.out</i> als Subpackage von <i>vehicle</i></li> und erstelle das Datenbank Repository <i>VehicleDbRepository</i></li>
<li>Implementiere den Use Case <i>VehicleRepository</i></li>
<li>Führe das DTO <i>VehicleDbEntity</i> (siehe Vorlage) sowie den Mapper <i>VehicleDbMapper</i> ein</li>.
<li>Ignoriere Details des Frameworks bei der Implementierung</li>

</ol>

<details>
      <summary>VehicleDbEntity</summary>

   ```java
public class VehicleDbEntity {

    private String vin;
    private String licensePlate;

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
}

   ```
   </details>

</details>
