package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileagehistory.MileageHistoryItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record VehicleMotionData(LicensePlate licensePlate, Mileage mileage, List<MileageHistoryItem> mileageHistory) {

    //default constructor
    public VehicleMotionData {
        validateVehicleMotionData(licensePlate, mileage);
    }
    public VehicleMotionData(LicensePlate licensePlate, Mileage mileage) {
        this(licensePlate, mileage, new ArrayList<>());
    }
    public VehicleMotionData updateMileage(Mileage mileage) {
        checkValidityOfNewMileage(mileage);
        checkPlausibilityOfNewMileage(mileage);
        mileageHistory.add(new MileageHistoryItem(mileage));
        return new VehicleMotionData(licensePlate, mileage, mileageHistory);
    }

    private void checkValidityOfNewMileage(Mileage mileage) {
        if(mileage == null) {
            throw new IllegalStateException("Mileage should not be null");
        }
    }

    private void checkPlausibilityOfNewMileage(Mileage mileage) {
        if(!mileageHistory.isEmpty()) {
            mileageHistory.sort(Comparator.comparing(MileageHistoryItem::date));
            MileageHistoryItem lastMileageHistoryItem = mileageHistory.getLast();
            if(lastMileageHistoryItem.mileage().mileageValue().value() >= mileage.mileageValue().value()) {
                throw new IllegalStateException("Mileage history is not plausible and can be manipulated");
            }
        }
    }

    private void validateVehicleMotionData(LicensePlate licensePlate, Mileage mileage) {
        if (isVehicleMotionDataValid(licensePlate, mileage)) {
            throw new IllegalStateException("vehicle motion data not valid");
        }
    }

    private boolean isVehicleMotionDataValid(LicensePlate licensePlate, Mileage mileage) {
        return licensePlate != null && mileage != null;
    }
}
