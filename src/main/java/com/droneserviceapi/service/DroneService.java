package com.droneserviceapi.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.droneserviceapi.data.payload.request.DroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;

@Component
public interface DroneService {
	
	MessageResponse register(DroneRequest drone);

	List<Drone> getBateryLevel(String serialno);
	
	Drone getDroneBySerialNo(String serialno);
	
	List<Drone> getAvailabeDrones();
	
	void loadDrone(int serialno);
	
}
