package com.droneserviceapi.modal;

import java.time.LocalDateTime;
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

	public LoadMedication() {
		
	}
	public LoadMedication(Integer trackingId, String source, String destination, LocalDateTime createdon, Drone drone,
			Medication medication) {
		super();
		this.trackingId = trackingId;
		this.source = source;
		this.destination = destination;
		this.createdon = createdon;
		this.drone = drone;
		this.medication = medication;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trackingid")
	private Integer trackingId;

//	@Column(name = "medication_code", columnDefinition = "VARCHAR(16) NOT NULL")
//	private String medicatioCode;

	@Column(name = "source", columnDefinition = "VARCHAR(30) NOT NULL")
	private String source;

	@Column(name = "destination", columnDefinition = "VARCHAR(30) NOT NULL")
	private String destination;

	@Column(name = "createdon", columnDefinition = "VARCHAR(30) NOT NULL")
	private LocalDateTime createdon;

	//@OneToOne(mappedBy = "loadMedication")
	//private MedicalDelivery medicalDelivery;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_serial_no", referencedColumnName = "serial_no")
	private Drone drone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_code", referencedColumnName = "code", unique = true)
	private Medication medication;
	
	
	

	public Integer getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Integer trackingId) {
		this.trackingId = trackingId;
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

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
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

	

}
