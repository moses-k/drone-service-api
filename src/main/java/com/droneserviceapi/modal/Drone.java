package com.droneserviceapi.modal;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tbl_drone")
public class Drone {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name = "id", columnDefinition = "VARCHAR(16) NOT NULL")
//	private Integer id;
	
	@Column(name = "serial_no", columnDefinition = "VARCHAR(16) NOT NULL")
	private String serialNumber;
	
	@Column(name = "weight_limit", columnDefinition = "VARCHAR(10) NOT NULL")
	private String weightLimit;
	
	@Column(name = "battery", columnDefinition = "VARCHAR(10) NOT NULL")
	private String battery;
	
	@Column(name = "model", columnDefinition = "VARCHAR(50) NOT NULL")//Lightweight, Middleweight, Cruiserweight, Heavyweight
	private String model;

	@Column(name = "drone_state", columnDefinition = "VARCHAR(20) NOT NULL")//IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
	private String state;
	
	@Column(name = "createdon", columnDefinition = "TIMESTAMP NULL DEFAULT NULL")
	private Date createdon;
	//@OneToMany(cascade = CascadeType.ALL)
    //@JoinTable(name = "drone_state",joinColumns = @JoinColumn(name = "serial_no"), inverseJoinColumns = @JoinColumn(name = "drone_id"))
    //private Set<State> states;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public String getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(String weightLimit) {
		this.weightLimit = weightLimit;
	}

	@Override
	public String toString() {
		return "Drone [serialNumber=" + serialNumber + ", weightLimit=" + weightLimit + ", battery=" + battery + ", model="
				+ model + ", state=" + state + ", createdon=" + createdon + "]";
	}


	
}
