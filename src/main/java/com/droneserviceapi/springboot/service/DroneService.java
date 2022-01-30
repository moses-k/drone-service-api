package com.droneserviceapi.springboot.service;

import com.droneserviceapi.modal.Drone;

public interface DroneService {
	
	String register(Drone drone);

	Drone getBateryLevel(int serialno);
	
	Drone getAvailabeDrone();
	
	void loadDrone(int serialno);
	
}
