package de.arkem.clean.arc.demo.app.lab.f.parts.catalogue.usecase.out;

import de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.ExplosionChart;
import de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.PartsCategoryCode;
import de.arkem.clean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle;

public interface FetchExplosionChart {
    ExplosionChart fetch(PartsCategoryCode partsCategoryId, Vehicle vehicle);
}
