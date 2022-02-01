package com.droneserviceapi.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.modal.LoadMedication;
import com.droneserviceapi.modal.Medication;
import com.droneserviceapi.repository.DroneRepository;
import com.droneserviceapi.repository.MedicationRepository;

@Service
public class DroneSeriviceImpl implements DroneService {

	@Autowired
	private DroneRepository droneRepository;
	@Autowired
	private MedicationRepository medicationRepository;

	public MessageResponse register(DroneRegisterRequest droneRequest) {
		Drone newdrone = new Drone();
		newdrone.setSerialNumber(droneRequest.getSerialNumber());
		newdrone.setModel(droneRequest.getModel());
		newdrone.setWeightLimit(droneRequest.getWeightLimit());
		newdrone.setBattery(droneRequest.getBattery());
		newdrone.setState(droneRequest.getState());
		droneRepository.save(newdrone);
		return new MessageResponse("New Drone created successfully");
	}

	public Drone getBateryLevel(DroneGetBatteryRequest drequest) {
		Drone newdrone = new Drone();
		newdrone.setSerialNumber(drequest.getSerialNumber());
		System.out.println("================== serialno " + newdrone.getSerialNumber());
		return droneRepository.findBySerialNumber(newdrone.getSerialNumber());
	}

	public Drone getDroneBySerialNo(String serialno) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Drone> getAvailabeDrones() {
		String state = "IDLE";
		return droneRepository.findAllByState(state);
	}

	public MessageResponse loadDrone(LoadDroneRequest loadRequest) {
		try {
			Drone drone = droneRepository.findBySerialNumber(loadRequest.getSerialNumber());
			Medication medication = medicationRepository.findByCode(loadRequest.getCode());

			//validate before loading
			if (drone == null) {
				return new MessageResponse("Drone specified does not exist");
			}

			if (medication == null) {
				return new MessageResponse("Medication specified does not exist");
			}

			if (drone.getWeightLimit() < medication.getWeight()) {
				return new MessageResponse("The Drone cannot load more than the weight limit");

			}
			
			//check battery
			
			
			
			//load
			
			LoadMedication  loadMedication = new LoadMedication();
			loadMedication.setTrackingId( Integer.valueOf(new Random(10).toString()));
			
			
			
			
			

		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}

		return new MessageResponse("Drone Loaded successfully");

	}

}
