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
@Table(name = "medical_delivery")
public class MedicalDelivery {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "delivery_time", columnDefinition = "TIMESTAMP NOT NULL")
	private LocalDateTime deliveryTime;

	@OneToOne(targetEntity = LoadMedication.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_trackingid", referencedColumnName = "trackingid")
	private LoadMedication loadMedication;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public LoadMedication getLoadMedication() {
		return loadMedication;
	}

	public void setLoadMedication(LoadMedication loadMedication) {
		this.loadMedication = loadMedication;
	}

}
