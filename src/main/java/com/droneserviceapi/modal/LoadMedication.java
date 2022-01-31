package com.droneserviceapi.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medication_loads")
public class LoadMedication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trackingid")
	private Integer trackingId;
	
	@Column(name = "drone_serialno", columnDefinition = "VARCHAR(16) NOT NULL")
	private String droneSerialNumber;
	
	@Column(name = "medication_code", columnDefinition = "VARCHAR(16) NOT NULL")
	private String medicatioCode;
	
	@Column(name = "source", columnDefinition = "VARCHAR(30) NOT NULL")
	private String source;
	
	@Column(name = "destination", columnDefinition = "VARCHAR(30) NOT NULL")
	private String destination;
	
	@Column(name = "createdon", columnDefinition = "VARCHAR(30) NOT NULL")
	private String createdon;

	public Integer getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Integer trackingId) {
		this.trackingId = trackingId;
	}

	public String getDroneSerialNumber() {
		return droneSerialNumber;
	}

	public void setDroneSerialNumber(String droneSerialNumber) {
		this.droneSerialNumber = droneSerialNumber;
	}

	public String getMedicatioCode() {
		return medicatioCode;
	}

	public void setMedicatioCode(String medicatioCode) {
		this.medicatioCode = medicatioCode;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCreatedon() {
		return createdon;
	}

	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

	@Override
	public String toString() {
		return "LoadMedication [trackingId=" + trackingId + ", droneSerialNumber=" + droneSerialNumber
				+ ", medicatioCode=" + medicatioCode + ", source=" + source + ", destination=" + destination
				+ ", createdon=" + createdon + "]";
	}

}
