package de.arkem.clean.arc.demo.app.vehicle.domain.model.risk.rating;

public record TheftStatus(Boolean value) {
    public TheftStatus {
        if (value == null) {
            throw new IllegalArgumentException("theft status is not valid");
        }
    }
}
