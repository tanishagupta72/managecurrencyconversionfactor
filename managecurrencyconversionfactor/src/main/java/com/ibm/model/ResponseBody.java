package com.ibm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseBody {

	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("Message")
	private String message;
	
	@JsonProperty("ConversionFactor")
	private double conversionFactor;
	
	public ResponseBody()
	{
		
	}
	
	public ResponseBody(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public ResponseBody(String status, String message, double conversionFactor) {
		super();
		this.status = status;
		this.message = message;
		this.conversionFactor = conversionFactor;
	}

	
	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
