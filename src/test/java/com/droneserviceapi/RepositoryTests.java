package com.droneserviceapi;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.repository.DroneRepository;
import org.assertj.core.api.Assertions;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryTests {
	@Autowired
	DroneRepository droneRepository;
	
	@Test
	public void testAddnewDrone() {
		Drone drone = new Drone("Q23RT5676697", "Sonny", 1200.0, new BigDecimal(0.95), "IDLE");
		droneRepository.save(drone);
		
		Iterable<Drone> drones = droneRepository.findAll();
	    Assertions.assertThat(drones).extracting(Drone::getSerialNumber).contains(drone.getSerialNumber());
	    droneRepository.deleteAll();
	    Assertions.assertThat(droneRepository.findAll()).isEmpty();

	}
}
