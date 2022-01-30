package com.droneserviceapi.service;

import org.springframework.stereotype.Component;

import com.droneserviceapi.data.payload.request.DroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;

@Component
public interface DroneService {
	
	MessageResponse register(DroneRequest drone);

	Drone getBateryLevel(String serialno);
	
	Drone getDroneBySerialNo(String serialno);
	
	Drone getAvailabeDrones();
	
	void loadDrone(int serialno);
	
}
