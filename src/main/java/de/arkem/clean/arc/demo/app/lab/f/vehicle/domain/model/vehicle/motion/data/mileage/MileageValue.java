package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileage;

public record MileageValue(Double value)  {

    public MileageValue {

    }

    private void validateMileageValue(Double value) {

    }

    private boolean isMileageValueValid(Double value) {
        return value != null && value >= 3;
    }

}
