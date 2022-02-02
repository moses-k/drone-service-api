package com.droneserviceapi.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medication")
public class Medication {

	public Medication() {
		
	}
	
	public Medication(String code, String name, double weight, String image) {
		super();
		this.code = code;
		this.name = name;
		this.weight = weight;
		this.image = image;
	}

	@Id
	@Column(name = "code", columnDefinition = "VARCHAR(16) NOT NULL")
	private String code;

	@Column(name = "name", columnDefinition = "VARCHAR(30) NOT NULL")
	private String name;

	@Column(name = "weight", columnDefinition = "VARCHAR(10) NOT NULL")
	private double weight;

	@Column(name = "medication_image")
	private String image;
	
	

	//@OneToOne(mappedBy = "medication")
	//private LoadMedication loadMedication;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImage() {
		return image;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Medication [code=" + code + ", name=" + name + ", weight=" + weight + ",  image=" + image + "]";
	}

}
