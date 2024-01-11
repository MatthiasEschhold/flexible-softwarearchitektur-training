package de.arkem.clean.arc.demo.app.lab.f.vehicle.domain.model.theft.status;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.theft.status.TheftStatusEnum;

public record TheftStatus(TheftStatusEnum value) {

    public TheftStatus {
        validateTheftStatus(value);
    }

    private void validateTheftStatus(TheftStatusEnum value) {
        if (!isTheftStatusValid(value)) {
            throw new IllegalStateException("anti theft status not valid");
        }
    }

    private boolean isTheftStatusValid(TheftStatusEnum value) {
        return value != null;
    }
}
