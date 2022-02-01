package com.droneserviceapi.data.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoadDroneRequest {

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
