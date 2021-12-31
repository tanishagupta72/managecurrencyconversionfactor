package com.ibm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Currency {

	@Id
	@GeneratedValue
	private int id;
	
	private String currency;
	private String countryCode;
	private double conversionFactor;
	
	public Currency()
	{
		
	}

	public Currency( String currency, String countryCode, double conversionFactor) {
		super();
		
		this.currency = currency;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}
	

	public Currency(int id, String currency, String countryCode, double conversionFactor) {
		super();
		this.id = id;
		this.currency = currency;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
