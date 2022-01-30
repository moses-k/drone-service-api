package com.droneserviceapi.data.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DroneRequest {
	
	@NotBlank
	@NotNull
	private String serialNumber;
	
	@NotBlank
	@NotNull
	private String model;
	
	@NotBlank
	@NotNull
	private String weight;

	@NotBlank
	@NotNull
	private String battery;
	
	@NotBlank
	@NotNull
	private String state;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
