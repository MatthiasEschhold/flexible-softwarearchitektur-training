package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileage;

public enum MileageUnit {
    KM("KM"), MILES("MILES");

    String value;
    MileageUnit(String value) {
        this.value = value;
    }
}
