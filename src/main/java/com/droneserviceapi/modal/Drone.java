package com.droneserviceapi.modal;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_drone")
public class Drone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "serial_no", columnDefinition = "VARCHAR(16) NOT NULL")
	private Integer serialNumber;
	
	@Column(name = "weight", columnDefinition = "VARCHAR(10) NOT NULL")
	private String weight;
	
	@Column(name = "battery", columnDefinition = "VARCHAR(10) NOT NULL")
	private String battery;
	
	@Column(name = "model", columnDefinition = "VARCHAR(50) NOT NULL")//Lightweight, Middleweight, Cruiserweight, Heavyweight
	private String model;

	@Column(name = "drone_state", columnDefinition = "VARCHAR(20) NOT NULL")//IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
	private String state;
	//@OneToMany(cascade = CascadeType.ALL)
    //@JoinTable(name = "drone_state",joinColumns = @JoinColumn(name = "serial_no"), inverseJoinColumns = @JoinColumn(name = "drone_id"))
    //private Set<State> states;

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
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

	@Override
	public String toString() {
		return "Drone [serialNumber=" + serialNumber + ", weight=" + weight + ", battery=" + battery + ", model="
				+ model + ", state=" + state + "]";
	}
	
}
