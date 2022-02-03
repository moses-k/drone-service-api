package com.droneserviceapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.droneserviceapi.controller.DroneMainController;
import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.AvailableDroneResponse;
import com.droneserviceapi.data.payload.response.DroneBatteryDetailsResponse;
import com.droneserviceapi.data.payload.response.DroneMedicationLoadRsponse;
import com.droneserviceapi.data.payload.response.LoadDroneResponse;
import com.droneserviceapi.data.payload.response.RegisterDroneResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.modal.Medication;
import com.droneserviceapi.service.DroneSeriviceImpl;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
class TestDroneMainController {

	@InjectMocks
	DroneMainController droneMainController;
	@Mock
	DroneSeriviceImpl droneService;

	@Test
	public void testRegisterDrone() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		RegisterDroneResponse registerDroneResponse = new RegisterDroneResponse();
		registerDroneResponse.setMessage("success");
		registerDroneResponse.setSerialNumber("Q23RT5676697");
		registerDroneResponse.setMessage("New Drone created successfully");
		registerDroneResponse.setTimestamp(java.time.LocalDateTime.now());

		when(droneService.register(any(DroneRegisterRequest.class))).thenReturn(registerDroneResponse);

		DroneRegisterRequest drone = new DroneRegisterRequest("Q23RT5676697", "Sonny", 1200.0, new BigDecimal(0.95),
				"DELIVERED");
		ResponseEntity<RegisterDroneResponse> responseEntity = droneMainController.registerDrone(drone);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getBody()).isEqualTo(registerDroneResponse);
		//assertEquals(registerDroneResponse, responseEntity);

	}

	@Test
	void testGetAvailableDroneForLoading() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		List<Drone> list = new ArrayList<Drone>();
		Drone drone1 = new Drone("Q23RT5676697", "Sonny", 1200.0, new BigDecimal(0.95), "IDLE");
		Drone drone2 = new Drone("Q23RT5676698", "Huawei", 1500.0, new BigDecimal(1), "IDLE");
		Drone drone3 = new Drone("Q23RT5676699", "Oraimo", 2000.0, new BigDecimal(0.98), "IDLE");
		list.add(drone1);
		list.add(drone2);
		list.add(drone3);

		AvailableDroneResponse availableDrone = new AvailableDroneResponse("success", java.time.LocalDateTime.now(),
				list);

		when(droneService.getAvailabeDrones()).thenReturn(availableDrone);

		ResponseEntity<AvailableDroneResponse> responseEntity = droneMainController.getAvailableDroneForLoading();
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200); // Created
		assertThat(responseEntity.getBody().getStatus()).isEqualTo("success");
		assertThat(responseEntity.getBody().getDrones().size()).isEqualTo(3);

	}

	@Test
	public void testCheckDroneBattery() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		DroneBatteryDetailsResponse droneBattery = new DroneBatteryDetailsResponse("success", "Q23RT5676697", "98%",
				java.time.LocalDateTime.now());
		when(droneService.getBateryLevel(any(DroneGetBatteryRequest.class))).thenReturn(droneBattery);

		ResponseEntity<DroneBatteryDetailsResponse> responseEntity = droneMainController
				.checkDroneBattery(new DroneGetBatteryRequest("Q23RT5676697"));
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getBody()).isEqualTo(droneBattery);

	}

	@Test
	public void testLoadDroneWithMedication() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		LoadDroneResponse droneResponse = new LoadDroneResponse();
		droneResponse.setResult("sucess");
		droneResponse.setSerialNumber("Q23RT5676697");
		droneResponse.setMessage("Drone Loaded successfully");
		droneResponse.setTimestamp(java.time.LocalDateTime.now());

		when(droneService.loadDrone(any(LoadDroneRequest.class))).thenReturn(droneResponse);

		LoadDroneRequest loadRequest = new LoadDroneRequest("Q23RT5676697", "Nairobi", "Mumbai", "POQ1223465G");
		ResponseEntity<LoadDroneResponse> responseEntity = droneMainController.loadDroneWithMedication(loadRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getBody()).isEqualTo(droneResponse);

	}

	@Test
	public void testCheckLoadedMedicationItem() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Medication medication = new Medication("YT5432RT", "Panadol", 400, "t345tghhyt");
		DroneMedicationLoadRsponse droneMedicationLoadRsponse = new DroneMedicationLoadRsponse();
		droneMedicationLoadRsponse.setResult("success");
		droneMedicationLoadRsponse.setSerialNumber("Q23RT5676697");
		droneMedicationLoadRsponse.setTimestamp(java.time.LocalDateTime.now());
		droneMedicationLoadRsponse.setMedication(medication);

		String serialNumber = "Q23RT5676697";
		when(droneService.getLoadedMedicationForADrone(serialNumber)).thenReturn(droneMedicationLoadRsponse);

		ResponseEntity<DroneMedicationLoadRsponse> responseEntity = droneMainController
				.checkLoadedMedicationItem(serialNumber);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		assertThat(responseEntity.getBody()).isEqualTo(droneMedicationLoadRsponse);

	}

}
