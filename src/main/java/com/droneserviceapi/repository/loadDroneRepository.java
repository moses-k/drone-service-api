package com.droneserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.droneserviceapi.modal.LoadMedication;

public interface loadDroneRepository extends JpaRepository<LoadMedication, String>{

}
