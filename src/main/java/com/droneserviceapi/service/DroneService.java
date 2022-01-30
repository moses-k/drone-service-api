package com.droneserviceapi.service;

import com.droneserviceapi.modal.DroneDto;

public interface DroneService {
	
	String register(DroneDto drone);

	DroneDto getBateryLevel(String serialno);
	
	DroneDto getDroneBySerialNo(String serialno);
	
	DroneDto getAvailabeDrones();
	
	void loadDrone(int serialno);
	
}
