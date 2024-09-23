package de.arkem.clean.arc.demo.app.vehicle.adapter.in.spareparts;

import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.vehicle.usecase.in.GetVehicleByVin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vehicleData")
public class VehicleDataController {

    private final GetVehicleByVin getVehicle;
    private final VehicleToVehicleDataResourceMapper resourceMapper;

    public VehicleDataController(GetVehicleByVin getVehicle, VehicleToVehicleDataResourceMapper resourceMapper) {
        this.getVehicle = getVehicle;
        this.resourceMapper = resourceMapper;
    }

    @GetMapping("/{vin}")
    public ResponseEntity<VehicleDataResource> readVehicle(String vin) {
        Vehicle vehicle = getVehicle.get(new Vin(vin));
        return ResponseEntity.ok(resourceMapper.mapVehicleToResource(vehicle));
    }
}
