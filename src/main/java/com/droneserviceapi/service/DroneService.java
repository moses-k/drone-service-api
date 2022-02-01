package com.droneserviceapi.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.droneserviceapi.data.payload.request.DroneDeliveryRequest;
import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.modal.LoadMedication;

@Component
public interface DroneService {
	
	MessageResponse register(DroneRegisterRequest drone);

	Drone getBateryLevel(DroneGetBatteryRequest drequest) throws Exception;
	
	LoadMedication getLoadedMedicationForADrone(String serialno);
	
	List<Drone> getAvailabeDrones();
	
	MessageResponse loadDrone(LoadDroneRequest loadRequest);
	
	MessageResponse deliverLoad(DroneDeliveryRequest loadRequest);

	
}
