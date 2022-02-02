package com.droneserviceapi.data.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoadDroneRequest {

	public LoadDroneRequest() {
		
	}
	
	public LoadDroneRequest(@NotNull @NotBlank String serialNumber, @NotNull @NotBlank String source,
			@NotNull @NotBlank String destination, @NotNull @NotBlank String code) {
		super();
		this.serialNumber = serialNumber;
		this.source = source;
		this.destination = destination;
		this.code = code;
	}

	@NotNull
	@NotBlank
	private String serialNumber;
	
	@NotNull
	@NotBlank
	private String source;
	
	@NotNull
	@NotBlank
	private String destination;
	
	@NotNull
	@NotBlank
	private String code;
	
	

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
}
