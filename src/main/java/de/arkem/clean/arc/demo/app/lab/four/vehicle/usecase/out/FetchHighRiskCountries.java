package de.arkem.clean.arc.demo.app.lab.four.vehicle.usecase.out;

import de.arkem.clean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.HighRiskCountry;

import java.util.List;

public interface FetchHighRiskCountries {
    List<HighRiskCountry> fetch();
}
