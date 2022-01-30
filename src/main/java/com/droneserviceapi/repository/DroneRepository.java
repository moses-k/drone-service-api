package com.droneserviceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droneserviceapi.modal.Drone;

public interface DroneRepository extends JpaRepository<Drone, Integer>{

}
