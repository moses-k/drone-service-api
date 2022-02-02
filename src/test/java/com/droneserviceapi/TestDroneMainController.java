package com.droneserviceapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.droneserviceapi.controller.DroneMainController;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.modal.LoadMedication;
import com.droneserviceapi.repository.DroneRepository;
import com.droneserviceapi.repository.loadDroneRepository;
import com.droneserviceapi.service.DroneSeriviceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.status.Status;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
class TestDroneMainController {

	@InjectMocks
    DroneMainController droneMainController;
	@Mock
	DroneRepository droneRepository;
	@Mock
	loadDroneRepository loadDroneRepository;
	@Mock
	DroneSeriviceImpl droneService;
	
	
//	@Test
//	public void register() {
//		mvc.perform( MockMvcRequestBuilders
//			      .post("/register")
//			      .content(asJsonString(new DroneRegisterRequest("Q23RT5676697","Sonny","1200","0.95","IDLE")))
//			      .contentType("application/json")
//			      .accept("application/json")
//			      .andExpect(Status().isCreated())
//			      .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
//		
//	}
	
	@Test
	public void testRegisterDrone() 
   {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//         
//        when(droneService.register(any(DroneRegisterRequest.class))).thenReturn(new MessageResponse("New Drone created successfully"));        
//        DroneRegisterRequest drone = new DroneRegisterRequest("Q23RT5676697","Sonny",1200.0 , new BigDecimal(0.95), "DELIVERED");
//        ResponseEntity<MessageResponse> responseEntity = droneMainController.registerDrone(drone);
//       
//        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
//        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/Q23RT5676697");
   }
	
}
