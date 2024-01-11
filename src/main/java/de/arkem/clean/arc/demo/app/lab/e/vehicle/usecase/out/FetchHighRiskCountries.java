package de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.theft.status.HighRiskCountry;

import java.util.List;

public interface FetchHighRiskCountries {
    List<HighRiskCountry> fetch();
}
