package com.droneserviceapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droneserviceapi.data.payload.request.DroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.repository.DroneRepository;

@Service
public class DroneSeriviceImpl implements DroneService{

	@Autowired
	DroneRepository droneRepository;
	
	public MessageResponse register(DroneRequest droneRequest) {
		Drone newdrone = new Drone();
		newdrone.setSerialNumber(droneRequest.getSerialNumber());
		newdrone.setModel(droneRequest.getModel());
		newdrone.setWeightLimit(droneRequest.getWeightLimit());
		newdrone.setBattery(droneRequest.getBattery());
		newdrone.setState(droneRequest.getState());
		droneRepository.save(newdrone);
		
		return new MessageResponse("New Drone created successfully");
	}

	public Drone getBateryLevel(String serialno) {
		// TODO Auto-generated method stub
		return null;
	}

	public Drone getDroneBySerialNo(String serialno) {
		// TODO Auto-generated method stub
		return null;
	}

	public Drone getAvailabeDrones() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loadDrone(int serialno) {
		// TODO Auto-generated method stub
		
	}

	





}
