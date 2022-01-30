package com.droneserviceapi.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medication")
public class Medication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", columnDefinition = "INT NOT NULL")
	private int id;
	
	@Column(name = "name", columnDefinition = "VARCHAR(30) NOT NULL")
	private String name;
	
	@Column(name="weight", columnDefinition = "VARCHAR(10) NOT NULL")
	private String weight;
	
	@Column(name = "code", columnDefinition = "VARCHAR(30) NOT NULL")
	private String code;
	
	@Column(name = "medication_image")
	private String image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
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

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Medication [id=" + id + ", name=" + name + ", weight=" + weight + ", code=" + code + ", image=" + image
				+ "]";
	}
	

}
