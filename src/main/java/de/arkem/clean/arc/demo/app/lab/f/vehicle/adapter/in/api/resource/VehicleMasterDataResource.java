package de.arkem.clean.arc.demo.app.lab.f.vehicle.adapter.in.api.resource;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.resource.EquipmentResource;

import java.util.List;

public class VehicleMasterDataResource {
    private List<EquipmentResource> equipmentList;

    public List<EquipmentResource> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<EquipmentResource> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
