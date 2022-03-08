package com.droneserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droneserviceapi.modal.Medication;

public interface MedicationPreloadDataRepository extends JpaRepository<Medication, String> {

	
	
}
