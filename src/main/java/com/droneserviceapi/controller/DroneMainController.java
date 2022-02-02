package com.droneserviceapi.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.droneserviceapi.data.payload.request.DroneDeliveryRequest;
import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.modal.LoadMedication;
import com.droneserviceapi.service.DroneSeriviceImpl;

@RestController
@RequestMapping("/api/drone")
@Validated
public class DroneMainController {
	@Autowired
	private DroneSeriviceImpl droneService;

	@PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<MessageResponse> registerDrone(
			@Valid @NotNull @RequestBody DroneRegisterRequest dronerequest) {
		MessageResponse newDrone = droneService.register(dronerequest);
		return new ResponseEntity<MessageResponse>(newDrone, HttpStatus.CREATED);
	}

	@GetMapping("/available")
	public ResponseEntity<List<Drone>> getAvailableDrones() {
		List<Drone> drones = droneService.getAvailabeDrones();
		return new ResponseEntity<List<Drone>>(drones, HttpStatus.CREATED);
	}

	@PostMapping("/battery")
	public ResponseEntity<Drone> getDroneBateryLevel(
			@NotNull @RequestBody(required = true) DroneGetBatteryRequest drequest) {
		if (drequest.getSerialNumber() == null || drequest.getSerialNumber().isEmpty()) {
			throw new RuntimeException("SerialNumber is Required");
		}
		Drone newDrone = droneService.getBateryLevel(drequest);
		return new ResponseEntity<Drone>(newDrone, HttpStatus.CREATED);
	}

	@PostMapping("/load")
	public ResponseEntity<MessageResponse> registerDrone(@NotNull @RequestBody LoadDroneRequest loadrequest) {
		MessageResponse newDrone = droneService.loadDrone(loadrequest);
		return new ResponseEntity<MessageResponse>(newDrone, HttpStatus.CREATED);
	}

	@GetMapping(path = "details/{serialNumber}")
	public ResponseEntity<LoadMedication> getDronesLoads(@PathVariable("serialNumber") String serialNumber) {
		LoadMedication load = droneService.getLoadedMedicationForADrone(serialNumber);
		return new ResponseEntity<LoadMedication>(load, HttpStatus.CREATED);
	}

	@PostMapping("/deliver")
	public ResponseEntity<MessageResponse> registerDrone(@NotNull @RequestBody DroneDeliveryRequest deliverRequest) {
		MessageResponse delivery = droneService.deliverLoad(deliverRequest);
		return new ResponseEntity<MessageResponse>(delivery, HttpStatus.CREATED);
	}

}
