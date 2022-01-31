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
	private String weightLimit;

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

	public String getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(String weightLimit) {
		this.weightLimit = weightLimit;
	}

	public void setModel(String model) {
		this.model = model;
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
