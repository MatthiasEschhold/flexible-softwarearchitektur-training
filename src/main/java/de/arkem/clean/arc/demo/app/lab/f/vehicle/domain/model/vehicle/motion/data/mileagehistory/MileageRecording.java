package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileagehistory;

import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileage.Mileage;

import java.util.Date;

public record MileageRecording(Mileage mileage, Date date) {
    
    public MileageRecording {
        validateMileageHistoryObject(mileage, date);
    }

    public MileageRecording(Mileage mileage) {
        this(mileage, new Date());
    }

    private void validateMileageHistoryObject(Mileage mileage, Date date) {
        //@ToDo: Implement
    }
}
