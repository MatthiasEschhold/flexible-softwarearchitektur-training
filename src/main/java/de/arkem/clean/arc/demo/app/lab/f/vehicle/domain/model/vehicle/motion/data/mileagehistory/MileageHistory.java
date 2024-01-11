package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileagehistory;

import de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.vehicle.motion.data.mileagehistory.MileageHistoryItem;

import java.util.List;

public record MileageHistory(List<MileageHistoryItem> mileageHistoryObjects) {

    public MileageHistory {
        validateMileageHistory(mileageHistoryObjects);
    }

    private void validateMileageHistory(List<MileageHistoryItem> mileageHistoryObjects) {
        //@ToDo: Implement
    }
}
