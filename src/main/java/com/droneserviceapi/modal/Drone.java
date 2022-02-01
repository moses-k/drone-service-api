package com.droneserviceapi.modal;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_drone")
public class Drone {

	@Id
	@Column(name = "serial_no", columnDefinition = "VARCHAR(16) NOT NULL")
	private String serialNumber;

	@Column(name = "weight_limit", columnDefinition = "VARCHAR(10) NOT NULL")
	private double weightLimit;

	@Column(name = "battery",precision = 3, scale = 2)
	private BigDecimal battery;
	
	@Column(name = "model", columnDefinition = "VARCHAR(50) NOT NULL") // Lightweight, Middleweight, Cruiserweight,
																		// Heavyweight
	private String model;

	@Column(name = "drone_state", columnDefinition = "VARCHAR(20) NOT NULL") // IDLE, LOADING, LOADED, DELIVERING,
																				// DELIVERED, RETURNING
	private String state;

	@OneToOne(mappedBy = "drone")
	private LoadMedication loadMedication;

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

	public double getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}

	public String getState() {
		return state;
	}

	public BigDecimal getBattery() {
		return battery;
	}

	public void setBattery(BigDecimal battery) {
		this.battery = battery;
	}

	public LoadMedication getLoadMedication() {
		return loadMedication;
	}

	public void setLoadMedication(LoadMedication loadMedication) {
		this.loadMedication = loadMedication;
	}

	public void setState(String state) {
		this.state = state;
	}

}
