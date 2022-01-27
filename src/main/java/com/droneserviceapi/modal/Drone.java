package com.droneserviceapi.modal;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_drone")
public class Drone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Serial_no")
	private Integer serialNumber;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "battery")
	private String battery;
	
	//private Set<State> states;
	
}
