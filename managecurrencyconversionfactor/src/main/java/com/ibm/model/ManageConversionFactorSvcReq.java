package com.ibm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageConversionFactorSvcReq {

	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("country_code")
	private String countryCode;
	
	@JsonProperty("conversion_factor")
	private double conversionFactor;
	
	public ManageConversionFactorSvcReq()
	{}

	public ManageConversionFactorSvcReq(String currency, String countryCode, double conversionFactor) {
		super();
		this.currency = currency;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	
	
	
}
