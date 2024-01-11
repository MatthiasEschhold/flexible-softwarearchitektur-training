package de.arkem.clean.arc.demo.app.lab.d.vehicle.adapter.out.db.high.risk.model;

import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskVehicleModel;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.domain.model.theft.status.HighRiskVehicleModels;
import de.arkem.clean.arc.demo.app.lab.d.vehicle.usecase.out.FetchHighRiskVehicleModels;

import java.util.Arrays;

public class HighRiskModelRepository implements FetchHighRiskVehicleModels {

    @Override
    public HighRiskVehicleModels fetch() {
        return createHighRiskVehicleModels();
    }

    private HighRiskVehicleModels createHighRiskVehicleModels() {
        return new HighRiskVehicleModels(
                Arrays.asList(HighRiskVehicleModel.GRAND_CHEROKEE_FOURTH_GENERATION,
                        HighRiskVehicleModel.RANGE_ROVER_SECOND_GENERATION,
                        HighRiskVehicleModel.RANGE_ROVER_THIRD_GENERATION,
                        HighRiskVehicleModel.STRINGER_FIRST_GENERATION,
                        HighRiskVehicleModel.LAND_CRUSIER_FOURTH_GENERATION)
        );
    }
}
