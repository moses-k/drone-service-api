package com.droneserviceapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.droneserviceapi.data.payload.response.AvailableDroneResponse;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.repository.DroneRepository;
import com.droneserviceapi.service.DroneSeriviceImpl;

@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
class ServiceTests {

	@InjectMocks
	DroneSeriviceImpl droneServiceImpl;
	@Mock
	DroneRepository droneRepository;
	
	@Test
	public void testGetAvailabeDrones() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		List<Drone> list = new ArrayList<Drone>();
		Drone drone1 = new Drone("Q23RT5676697", "Sonny", 1200.0, new BigDecimal(0.95), "IDLE");
		Drone drone2 = new Drone("Q23RT5676698", "Huawei", 1500.0, new BigDecimal(1), "IDLE");
		Drone drone3 = new Drone("Q23RT5676699", "Oraimo", 2000.0, new BigDecimal(0.98), "IDLE");
		Drone drone4 = new Drone("Q23RT5676610", "Oraimo", 2000.0, new BigDecimal(0.98), "IDLE");
		list.add(drone1);
		list.add(drone2);
		list.add(drone3);
		list.add(drone4);
		
		LocalDateTime time = java.time.LocalDateTime.now();
		AvailableDroneResponse availableDroneResponse = new AvailableDroneResponse();
		availableDroneResponse.setStatus("success");
		availableDroneResponse.setTimestamp(time);
		availableDroneResponse.setDrones(list);
		
		String state = "IDLE";
		when(droneRepository.findAllByState(state)).thenReturn(list);

		// test
		AvailableDroneResponse availableDrones = droneServiceImpl.getAvailabeDrones();
		assertEquals(4, availableDrones.getDrones().size()); //assertThat(availableDrones.size()).isEqualTo(4);
		verify(droneRepository, times(1)).findAllByState(state);
	}

}
