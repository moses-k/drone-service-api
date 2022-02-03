package com.droneserviceapi.data.payload.response;

import java.time.LocalDateTime;

public class RegisterDroneResponse {
	
	public RegisterDroneResponse() {
		
	}
	public RegisterDroneResponse(String result, String serialNumber, String message, LocalDateTime timestamp) {
		super();
		this.result = result;
		this.serialNumber = serialNumber;
		this.message = message;
		this.timestamp = timestamp;
	}
	private String result;
	private String serialNumber;
	private String message;
	private LocalDateTime timestamp;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
