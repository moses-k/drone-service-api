package com.droneserviceapi.service;

import org.springframework.stereotype.Component;

import com.droneserviceapi.data.payload.request.DroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.DroneDto;

@Component
public interface DroneService {
	
	MessageResponse register(DroneRequest drone);

	DroneDto getBateryLevel(String serialno);
	
	DroneDto getDroneBySerialNo(String serialno);
	
	DroneDto getAvailabeDrones();
	
	void loadDrone(int serialno);
	
}
