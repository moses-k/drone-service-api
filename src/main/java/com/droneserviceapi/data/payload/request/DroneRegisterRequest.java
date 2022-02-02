package com.droneserviceapi.data.payload.request;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DroneRegisterRequest {
	
	@NotBlank
	@NotNull
	private String serialNumber;
	
	@NotBlank
	@NotNull
	private String model;
	
	@NotNull
	private double weightLimit;

	@NotNull
	private BigDecimal battery;
	
//	public DroneRegisterRequest(@NotBlank @NotNull String serialNumber, @NotBlank @NotNull String model,
//			@NotBlank @NotNull double weightLimit, @NotBlank @NotNull BigDecimal battery,
//			@NotBlank @NotNull String state) {
//		super();
//		this.serialNumber = serialNumber;
//		this.model = model;
//		this.weightLimit = weightLimit;
//		this.battery = battery;
//		this.state = state;
//	}

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

	public double getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getBattery() {
		return battery;
	}

	public void setBattery(BigDecimal battery) {
		this.battery = battery;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
