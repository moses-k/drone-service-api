package com.droneserviceapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
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
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.response.MessageResponse;
import com.droneserviceapi.service.DroneSeriviceImpl;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
class TestDroneMainController {

	@InjectMocks
	DroneMainController droneMainController;
	@Mock
	DroneSeriviceImpl droneService;

	@SuppressWarnings("unlikely-arg-type")
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
		assertThat(responseEntity.getBody().getMessage().equals(responseEntity));
		// assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/Q23RT5676697");

	}
	
	@Test
	public void testgetAvailableDrones() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		
		
	}

}
