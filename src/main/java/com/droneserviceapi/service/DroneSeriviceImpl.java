package com.droneserviceapi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.droneserviceapi.data.payload.request.DroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.repository.DroneRepository;

@Service
public class DroneSeriviceImpl implements DroneService{

	@Autowired
	private DroneRepository droneRepository;
	
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

	public List<Drone> getBateryLevel(String serialno) {
		
		System.out.println("=========================== serialno "+ serialno);
	    return droneRepository.findBySerialNumber(serialno);
	}

	public Drone getDroneBySerialNo(String serialno) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Drone> getAvailabeDrones() {
		String state = "IDLE";
       return droneRepository.findAllByState(state);
	}

	public void loadDrone(int serialno) {
		// TODO Auto-generated method stub
		
	}

	





}
