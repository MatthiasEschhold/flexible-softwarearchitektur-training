package de.arkem.clean.arc.demo.app.lab.f.parts.catalogue.domain.model;

import de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.PartsCategoryCode;
import de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.SparePart;
import de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle;

import java.util.List;

public class ExplosionChart {

    private de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle vehicle;
    private PartsCategoryCode partsCategory;
    private List<de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.SparePart> sparePartList;

    public ExplosionChart(de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle vehicle, PartsCategoryCode partsCategory, List<de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.SparePart> sparePartList) {
        this.vehicle = vehicle;
        this.partsCategory = partsCategory;
        this.sparePartList = sparePartList;
    }

    public void doSomeIdependentBusinessLogic() {
        //do some indepenendet domain-relate logic
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public PartsCategoryCode getPartsCategory() {
        return partsCategory;
    }

    public List<SparePart> getSparePartList() {
        return sparePartList;
    }
}
