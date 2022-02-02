package com.droneserviceapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.droneserviceapi.controller.DroneMainController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DroneApplicationTest {
	
	@Autowired
	DroneMainController droneMainController;

	@Test
	void contextLoads() {
        Assertions.assertThat(droneMainController).isNot(null);

	}

}
