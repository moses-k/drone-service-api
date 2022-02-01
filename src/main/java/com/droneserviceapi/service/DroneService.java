package com.droneserviceapi.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;

@Component
public interface DroneService {
	
	MessageResponse register(DroneRegisterRequest drone);

	Drone getBateryLevel(DroneGetBatteryRequest drequest) throws Exception;
	
	Drone getDroneBySerialNo(String serialno);
	
	List<Drone> getAvailabeDrones();
	
	MessageResponse loadDrone(LoadDroneRequest loadRequest);
	
}
