package com.droneserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droneserviceapi.modal.MedicalDelivery;

public interface DroneDeliveryRepository extends JpaRepository<MedicalDelivery, String> {

}
