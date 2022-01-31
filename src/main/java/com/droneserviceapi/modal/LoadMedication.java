package com.droneserviceapi.modal;

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
@Table(name = "drone_load")
public class LoadMedication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trackingid")
	private Integer trackingId;

	@Column(name = "medication_code", columnDefinition = "VARCHAR(16) NOT NULL")
	private String medicatioCode;

	@Column(name = "source", columnDefinition = "VARCHAR(30) NOT NULL")
	private String source;

	@Column(name = "destination", columnDefinition = "VARCHAR(30) NOT NULL")
	private String destination;

	@Column(name = "createdon", columnDefinition = "VARCHAR(30) NOT NULL")
	private String createdon;

	@OneToOne(mappedBy = "loadMedication")
	private MedicalDelivery medicalDelivery;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_serial_no", referencedColumnName = "serial_no")
	private Drone drone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_code", referencedColumnName = "code")
	private Medication medication;

	public Integer getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Integer trackingId) {
		this.trackingId = trackingId;
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

	public MedicalDelivery getMedicalDelivery() {
		return medicalDelivery;
	}

	public void setMedicalDelivery(MedicalDelivery medicalDelivery) {
		this.medicalDelivery = medicalDelivery;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	@Override
	public String toString() {
		return "LoadMedication [trackingId=" + trackingId + ", medicatioCode=" + medicatioCode + ", source=" + source
				+ ", destination=" + destination + ", createdon=" + createdon + ", medicalDelivery=" + medicalDelivery
				+ ", drone=" + drone + ", medication=" + medication + "]";
	}

}
