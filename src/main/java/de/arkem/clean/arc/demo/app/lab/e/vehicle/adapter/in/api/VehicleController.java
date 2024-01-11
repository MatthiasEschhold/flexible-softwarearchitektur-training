package de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api;

import de.arkem.clean.arc.demo.app.lab.e.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.motion.data.VehicleMotionData;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.domain.model.vehicle.Vin;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.in.VehicleCommand;
import de.arkem.clean.arc.demo.app.lab.e.vehicle.usecase.in.VehicleQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class VehicleController {
    private final VehicleToResourceApiMapper resourceMapper;
    private final VehicleToEntityApiMapper entityWebMapper;
    private final VehicleCommand vehicleCommand;
    private final VehicleQuery vehicleQuery;

    public VehicleController(VehicleToResourceApiMapper resourceMapper, VehicleToEntityApiMapper entityWebMapper,
                             VehicleCommand vehicleCommand, VehicleQuery vehicleQuery) {
        this.resourceMapper = resourceMapper;
        this.entityWebMapper = entityWebMapper;
        this.vehicleCommand = vehicleCommand;
        this.vehicleQuery = vehicleQuery;
    }

    //@GetMapping
    public VehicleResource readVehicle(String vin) {
        return resourceMapper.mapVehicleToResource(vehicleQuery.findByVin(new Vin(vin)));
    }

    //@PostMapping
    public ResponseEntity<VehicleResource> createVehicle(@RequestBody VehicleResource resource) {
        Vehicle createdVehice = performCreateVehicle(resource);
        VehicleResource createVehicleResource = resourceMapper.mapVehicleToResource(createdVehice);
        return ResponseEntity.ok(createVehicleResource);
    }

    private Vehicle performCreateVehicle(VehicleResource vehicleResource) {
        Vin vin = entityWebMapper.mapVinToEntity(vehicleResource.getVin());
        VehicleMotionData vehicleMotionData = entityWebMapper.mapVehicleMotionDataToEntity(vehicleResource.getVehicleMotionData());
        return vehicleCommand.createVehicle(vin, vehicleMotionData);
    }

    //@PatchMapping("vehicle/{vin}/mileage")
    public ResponseEntity<VehicleResource> updateMileageOfVehicle(/*@PathVariable("vin")*/ String vin, /*@RequestBody*/ MileageResource mileageResource) {
        Vehicle updatedVehice = vehicleCommand.updateMileage(new Vin(vin), entityWebMapper.mapMileageToEntity(mileageResource));
        VehicleResource updatedVehicleResource = resourceMapper.mapVehicleToResource(updatedVehice);
        return ResponseEntity.ok(updatedVehicleResource);
    }

}
