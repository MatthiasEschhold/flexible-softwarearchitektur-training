package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage;

public record Mileage(MileageUnit mileageUnit, MileageValue mileageValue) {
    public Mileage {
        validateMileage(mileageUnit, mileageValue);
    }

    private void validateMileage(MileageUnit mileageUnit, MileageValue mileageValue) {
        if (isMileageValid(mileageUnit, mileageValue)) {
            throw new IllegalStateException("Mileage should not be negative");
        }
    }

    private boolean isMileageValid(MileageUnit mileageUnit, MileageValue mileageValue) {
        return mileageUnit != null && mileageValue != null;
    }
}
