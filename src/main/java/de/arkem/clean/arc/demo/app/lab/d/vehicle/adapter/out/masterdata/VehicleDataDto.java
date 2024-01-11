package de.arkem.clean.arc.demo.app.lab.d.vehicle.adapter.out.masterdata;

public class VehicleDataDto {
    private String vehicleIdentificationNumber;
    private EquipmentListDto equipmentListDto;
    private String registrationCountry;
    private String vehicleModel;

    public String getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(String registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public EquipmentListDto getEquipmentListDto() {
        return equipmentListDto;
    }

    public void setEquipmentListDto(EquipmentListDto equipmentListDto) {
        this.equipmentListDto = equipmentListDto;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
