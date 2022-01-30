package com.droneserviceapi.modal;

import java.sql.Date;

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
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "drone_id", columnDefinition = "VARCHAR(16) NOT NULL")
	private String serialNumber;
	
	@Column(name = "state_description", columnDefinition = "VARCHAR(30) NOT NULL")
	private String stateDescription;
	
	@Column(name = "createdon", columnDefinition = "TIMESTAMP NULL DEFAULT NULL")
	private Date createdon;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStateDescription() {
		return stateDescription;
	}

	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", serialNumber=" + serialNumber + ", stateDescription=" + stateDescription
				+ ", createdon=" + createdon + "]";
	}

}
