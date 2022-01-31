package com.droneserviceapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.droneserviceapi.modal.Drone;

public interface DroneRepository extends JpaRepository<Drone, Integer> {

	List<Drone> findAllByState(@Param("drone_state") String state); // using method
	// @Query(value = "SELECT * from tbl_drone e where e.drone_state =:state ",
	// nativeQuery = true)//using @query with native
	// List<Drone> findAllByState(@Param("state") String state);

	@Query(value = "SELECT * from tbl_drone e where e.serial_no =:id ", nativeQuery = true) // using @query with
	List<Drone> findBySerialNumber(@Param("id") String id);

}
