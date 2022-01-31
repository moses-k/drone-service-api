package com.droneserviceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.droneserviceapi.data.payload.request.DroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.service.DroneSeriviceImpl;

@RestController
@RequestMapping("/api/drone")
public class DroneMainController {
	@Autowired
	private DroneSeriviceImpl droneService;

	@PostMapping("/register")
	public ResponseEntity<MessageResponse> registerDrone(@RequestBody DroneRequest dronerequest) {
		MessageResponse newDrone = droneService.register(dronerequest);
		return new ResponseEntity<MessageResponse>(newDrone, HttpStatus.CREATED);
	}

	@GetMapping("/available")
	public ResponseEntity<List<Drone>> getAvailableDrones() {
		List<Drone> drones = droneService.getAvailabeDrones();
		return new ResponseEntity<List<Drone>>(drones, HttpStatus.CREATED);
	}

	@PostMapping("/battery")
	public ResponseEntity<List<Drone>> getDroneBateryLevel(@RequestBody DroneRequest dronerequest) {
		List<Drone> dronesBatery = droneService.getBateryLevel(dronerequest.getSerialNumber());
		return new ResponseEntity<List<Drone>>(dronesBatery, HttpStatus.CREATED);
	}
}
