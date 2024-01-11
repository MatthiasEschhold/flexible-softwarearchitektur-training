package de.arkem.clean.arc.demo.app.lab.f.garage.order.adapter.out.vehicle;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.adapter.out.vehicle.VehicleToOriginVehicleMapper;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.five.garage.order.usecase.out.FetchVehicle;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.in.FetchVehicleByLicensePlate;

public class VehicleModuleClient implements FetchVehicle {

    private FetchVehicleByLicensePlate fetchVehicleByLicensePlate;
    private VehicleToOriginVehicleMapper mapper;

    public VehicleModuleClient(FetchVehicleByLicensePlate fetchVehicleByLicensePlate, VehicleToOriginVehicleMapper mapper) {
        this.fetchVehicleByLicensePlate = fetchVehicleByLicensePlate;
        this.mapper = mapper;
    }

    @Override
    public Vehicle fetch(LicensePlate licensePlate) {
        return mapper.mapOriginVehicleToVehicle(fetchVehicleByLicensePlate.fetchByLicensePlate(
                new LicensePlate(licensePlate.value())));
    }
}
