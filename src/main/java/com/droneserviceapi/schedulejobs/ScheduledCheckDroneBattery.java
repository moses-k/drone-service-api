package com.droneserviceapi.schedulejobs;

import java.text.DecimalFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.droneserviceapi.modal.Drone;
import com.droneserviceapi.repository.DroneRepository;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ScheduledCheckDroneBattery {
	
	@Autowired
	private DroneRepository droneRepository;
	
	static final Logger log = LoggerFactory.getLogger(ScheduledCheckDroneBattery.class);
	
    @Scheduled(fixedRate = 5000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        
        List<Drone> arrDroneBatteryLeves = droneRepository.findAll();
        
    	DecimalFormat decFormat = new DecimalFormat("#%");
        for(int i=0; i<arrDroneBatteryLeves.size(); i++) {
            
        	log.info("Batery level--: SerialNumber  "+ arrDroneBatteryLeves.get(i).getSerialNumber()+"  Battery Level "+ decFormat.format(arrDroneBatteryLeves.get(i).getBattery()));
        }
        Thread.sleep(5000);

    }
    
}
