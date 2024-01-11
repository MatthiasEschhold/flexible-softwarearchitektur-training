package de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileagehistory;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;

import java.util.Date;

public record MileageHistoryItem(Mileage mileage, Date date) {
    
    public MileageHistoryItem {
        validateMileageHistoryObject(mileage, date);
    }

    public MileageHistoryItem(Mileage mileage) {
        this(mileage, new Date());
    }

    private void validateMileageHistoryObject(Mileage mileage, Date date) {
        //@ToDo: Implement
    }
}
