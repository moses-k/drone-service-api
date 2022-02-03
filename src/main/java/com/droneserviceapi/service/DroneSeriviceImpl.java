package com.droneserviceapi.service;

import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.droneserviceapi.data.payload.request.DroneDeliveryRequest;
import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.AvailableDroneResponse;
import com.droneserviceapi.data.payload.response.DeliverDroneResponse;
import com.droneserviceapi.data.payload.response.DroneBatteryDetailsResponse;
import com.droneserviceapi.data.payload.response.DroneMedicationLoadRsponse;
import com.droneserviceapi.data.payload.response.LoadDroneResponse;
import com.droneserviceapi.data.payload.response.RegisterDroneResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.modal.LoadMedication;
import com.droneserviceapi.modal.MedicalDelivery;
import com.droneserviceapi.modal.Medication;
import com.droneserviceapi.repository.DroneDeliveryRepository;
import com.droneserviceapi.repository.DroneRepository;
import com.droneserviceapi.repository.MedicationRepository;
import com.droneserviceapi.repository.loadDroneRepository;

@Service
public class DroneSeriviceImpl implements DroneService {

	@Autowired
	private DroneRepository droneRepository;
	@Autowired
	private MedicationRepository medicationRepository;
	@Autowired
	private loadDroneRepository loadDroneRepository;
	@Autowired
	private DroneDeliveryRepository droneDeliveryRepository;

	@Override
	public RegisterDroneResponse register(DroneRegisterRequest droneRequest) {
		Drone newdrone = new Drone();
		newdrone.setSerialNumber(droneRequest.getSerialNumber());
		newdrone.setModel(droneRequest.getModel());
		newdrone.setWeightLimit(droneRequest.getWeightLimit());
		newdrone.setBattery(droneRequest.getBattery());
		newdrone.setState(droneRequest.getState());
		droneRepository.save(newdrone);

		RegisterDroneResponse droneResponse = new RegisterDroneResponse();
		droneResponse.setResult("success");
		droneResponse.setSerialNumber(newdrone.getSerialNumber());
		droneResponse.setMessage("New Drone created successfully");
		droneResponse.setTimestamp(java.time.LocalDateTime.now());

		return droneResponse;
	}

	@Override
	public AvailableDroneResponse getAvailabeDrones() {
		String state = "IDLE";
		List<Drone> drones = droneRepository.findAllByState(state);
		return new AvailableDroneResponse("status", java.time.LocalDateTime.now(), drones);
	}

	@Override
	public DroneBatteryDetailsResponse getBateryLevel(DroneGetBatteryRequest drequest) {

		Drone newdrone = new Drone();
		DecimalFormat decFormat = new DecimalFormat("#%");
		DroneBatteryDetailsResponse batteryDetailsResponse = new DroneBatteryDetailsResponse();
		newdrone.setSerialNumber(drequest.getSerialNumber());
		Drone droneBattery = droneRepository.findBySerialNumber(newdrone.getSerialNumber());
		if (droneBattery == null) {
			throw new RuntimeException("Drone battery level details not found");
		}

		batteryDetailsResponse.setStatus("success");
		batteryDetailsResponse.setSerialNumber(droneBattery.getSerialNumber());
		batteryDetailsResponse.setBattery(decFormat.format(droneBattery.getBattery()));
		batteryDetailsResponse.setTimestamp(java.time.LocalDateTime.now());

		return batteryDetailsResponse;
	}

	@Override
	public DroneMedicationLoadRsponse getLoadedMedicationForADrone(String serialno) {

		LoadMedication loadMedication = loadDroneRepository.findByDrone(serialno);
		if(loadMedication==null) {
			throw new RuntimeException("No load Medication details for the specified drone");
		}
		DroneMedicationLoadRsponse droneLoad = new DroneMedicationLoadRsponse();
		droneLoad.setResult("success");
		droneLoad.setSerialNumber(loadMedication.getDrone().getSerialNumber());
		droneLoad.setTimestamp(java.time.LocalDateTime.now());
		droneLoad.setMedication(loadMedication.getMedication());

		return droneLoad;
	}

	@Override
	public LoadDroneResponse loadDrone(LoadDroneRequest loadRequest) {

		droneRepository.setUpdateState("LOADING", loadRequest.getSerialNumber());
		Drone drone = droneRepository.findBySerialNumber(loadRequest.getSerialNumber());
		Medication medication = medicationRepository.findByCode(loadRequest.getCode());

		// validate before loading
		if (drone == null) {
			throw new RuntimeException("Drone specified does not exist");
		}

		if (medication == null) {
			throw new RuntimeException("Medication specified does not exist");
		}

		if (drone.getWeightLimit() < medication.getWeight()) {
			throw new RuntimeException("The Drone cannot load more than the weight limit");
		}
		// check battery
//			if(Integer.valueOf(drone.getBattery().toString()) <0.25){
//				return new MessageResponse("The Drone cannot loaded, battery below 25%");
//			}
		// load
		LoadMedication loadMedication = new LoadMedication();
		loadMedication.setDrone(drone);
		loadMedication.setMedication(medication);
		loadMedication.setSource(loadRequest.getSource());
		loadMedication.setDestination(loadRequest.getDestination());
		loadMedication.setCreatedon(java.time.LocalDateTime.now());
		loadDroneRepository.save(loadMedication);
		droneRepository.setUpdateState("LOADED", loadRequest.getSerialNumber());

		LoadDroneResponse loadDroneResponse = new LoadDroneResponse();
		loadDroneResponse.setResult("success");
		loadDroneResponse.setSerialNumber(loadRequest.getSerialNumber());
		loadDroneResponse.setMessage("Drone Loaded successfully");
		loadDroneResponse.setTimestamp(java.time.LocalDateTime.now());

		return loadDroneResponse;
	}

	@Override
	public DeliverDroneResponse deliverLoad(DroneDeliveryRequest loadRequest) {
		droneRepository.setUpdateState("DELIVERING", loadRequest.getSerialNumber());
		LoadMedication loadMedication = loadDroneRepository.findByDrone(loadRequest.getSerialNumber());
		
		if(loadMedication==null) {
			throw new RuntimeException("Drone specifies is not loaded or does not exist");
		}
		
		MedicalDelivery newdelivery = new MedicalDelivery();
		newdelivery.setLoadMedication(loadMedication);
		newdelivery.setDeliveryTime(java.time.LocalDateTime.now());
		droneDeliveryRepository.save(newdelivery);
		droneRepository.setUpdateState("DELIVERED", loadRequest.getSerialNumber());

		DeliverDroneResponse deliverDroneResponse = new DeliverDroneResponse();
		deliverDroneResponse.setResult("success");
		deliverDroneResponse.setSerialNumber(loadRequest.getSerialNumber());
		deliverDroneResponse.setMessage("Delivered successfully");
		deliverDroneResponse.setTimestamp(java.time.LocalDateTime.now());

		return deliverDroneResponse;
	}

}
