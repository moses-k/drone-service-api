package com.droneserviceapi.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drone_state")
public class State {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "state_id")
	private Integer id;
	
	@Column(name = "state_description")
	private String stateDescription;

}
