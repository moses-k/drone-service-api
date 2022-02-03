package com.droneserviceapi.data.payload.response;

import java.time.LocalDateTime;
import java.util.List;

import com.droneserviceapi.modal.Drone;

public class AvailableDroneResponse {
	
	public AvailableDroneResponse() {
		
		
	}
	public AvailableDroneResponse(String status, LocalDateTime timestamp, List<Drone> drones) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.drones = drones;
	}
	private String status;
	private LocalDateTime timestamp;
	private List<Drone> drones;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public List<Drone> getDrones() {
		return drones;
	}
	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}



}
