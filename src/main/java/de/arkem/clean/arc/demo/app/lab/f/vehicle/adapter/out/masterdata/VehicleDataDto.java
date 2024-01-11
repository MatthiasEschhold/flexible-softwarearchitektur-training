package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.out.masterdata;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.out.masterdata.EquipmentListDto;

public class VehicleDataDto {
    private String vehicleIdentificationNumber;
    private EquipmentListDto equipmentListDto;
    private String model;
    private String registrationCountry;

    public String getRegistrationCountry() {
        return registrationCountry;
    }

    public void setRegistrationCountry(String registrationCountry) {
        this.registrationCountry = registrationCountry;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
}
