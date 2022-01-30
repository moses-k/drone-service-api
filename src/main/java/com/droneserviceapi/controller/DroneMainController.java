package com.droneserviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.droneserviceapi.data.payload.request.DroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
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
		// return new ResponseEntity<>(newDrone, HttpStatus.CREATED);

	}

}
