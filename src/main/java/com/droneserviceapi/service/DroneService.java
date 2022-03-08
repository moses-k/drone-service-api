package com.droneserviceapi.service;

import org.springframework.stereotype.Component;
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

@Component
public interface DroneService {
	
	RegisterDroneResponse register(DroneRegisterRequest drone);

	DroneBatteryDetailsResponse getBateryLevel(DroneGetBatteryRequest drequest) throws Exception;
	
	DroneMedicationLoadRsponse getLoadedMedicationForADrone(String serialno);
	
	AvailableDroneResponse getAvailabeDrones();
	
	LoadDroneResponse loadDrone(LoadDroneRequest loadRequest);
	
	DeliverDroneResponse deliverLoad(DroneDeliveryRequest loadRequest);
	
	void preLoadData();

	
}
