package com.droneserviceapi;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.modal.LoadMedication;
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

		when(droneService.register(any(DroneRegisterRequest.class)))
				.thenReturn(new MessageResponse("New Drone created successfully"));

		DroneRegisterRequest drone = new DroneRegisterRequest("Q23RT5676697", "Sonny", 1200.0, new BigDecimal(0.95),
				"DELIVERED");
		ResponseEntity<MessageResponse> responseEntity = droneMainController.registerDrone(drone);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getBody().getMessage()).isEqualTo("New Drone created successfully");

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
		when(droneService.getAvailabeDrones()).thenReturn(list);

		ResponseEntity<List<Drone>> responseEntity = droneMainController.getAvailableDroneForLoading();
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201); // Created
		assertThat(responseEntity.getBody().size()).isEqualTo(3);

	}

	@Test
	public void testCheckDroneBattery() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Drone droneBattery = new Drone("Q23RT5676697", "Sonny", 1200.0, new BigDecimal(0.95), "IDLE");
		when(droneService.getBateryLevel(any(DroneGetBatteryRequest.class))).thenReturn(droneBattery);

		ResponseEntity<Drone> responseEntity = droneMainController
				.checkDroneBattery(new DroneGetBatteryRequest("Q23RT5676697"));
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getBody()).isEqualTo(droneBattery);

	}

	@Test
	public void testLoadDroneWithMedication() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(droneService.loadDrone(any(LoadDroneRequest.class)))
				.thenReturn(new MessageResponse("Drone Loaded successfully"));

		LoadDroneRequest loadRequest = new LoadDroneRequest("Q23RT5676697", "Nairobi", "Mumbai", "POQ1223465G");
		ResponseEntity<MessageResponse> responseEntity = droneMainController.loadDroneWithMedication(loadRequest);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getBody().getMessage()).isEqualTo("Drone Loaded successfully");

	}
	
	@Test
	public void testCheckLoadedMedicationItem() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Drone drone = new Drone("Q23RT5676697", "Sonny", 1200.0, new BigDecimal(0.95), "IDLE");
		Medication medication  = new Medication("YT5432RT","Panadol",400,"t345tghhyt");
		LoadMedication  loadMedication = new LoadMedication(1,"Nairobi","Mumbai",java.time.LocalDateTime.now() ,drone, medication);
		
		String serialNumber ="Q23RT5676697";
		when(droneService.getLoadedMedicationForADrone(serialNumber)).thenReturn(loadMedication);

		ResponseEntity<LoadMedication> responseEntity = droneMainController
				.checkLoadedMedicationItem(serialNumber);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getBody()).isEqualTo(loadMedication);

	}
	
	

}
