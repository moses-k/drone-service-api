package com.droneserviceapi.data.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DroneDeliveryRequest {
	@NotBlank
	@NotNull
	private String serialNumber;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
