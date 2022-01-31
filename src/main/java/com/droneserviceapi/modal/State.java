package com.droneserviceapi.modal;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drone_monitor")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "state", columnDefinition = "VARCHAR(30) NOT NULL")
	private String state;

	@Column(name = "createdon", columnDefinition = "TIMESTAMP NULL DEFAULT NULL")
	private Date createdon;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_serial_no", referencedColumnName = "serial_no")
	private Drone drone;

}
