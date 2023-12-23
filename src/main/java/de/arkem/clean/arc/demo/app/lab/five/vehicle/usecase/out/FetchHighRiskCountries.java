package de.arkem.clean.arc.demo.app.lab.five.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.five.vehicle.domain.model.theft.status.HighRiskCountry;

import java.util.List;

public interface FetchHighRiskCountries {
    List<HighRiskCountry> fetch();
}
