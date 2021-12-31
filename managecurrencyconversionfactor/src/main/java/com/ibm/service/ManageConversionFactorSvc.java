package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Currency;
import com.ibm.exception.ConversionFactorNotFoundException;
import com.ibm.exception.ConversionFactorNotUpdatedException;
import com.ibm.exception.ConversionFactorAlreadyExistsException;
import com.ibm.exception.CurrencyNotFoundException;
import com.ibm.model.ManageConversionFactorSvcReq;
import com.ibm.repository.CurrencyRepository;

@Service
public class ManageConversionFactorSvc {

	@Autowired
	CurrencyRepository currencyRepo;
	
	public Currency addConversionFactor(Currency currency)
	{
		if(currencyRepo.findCurrencyByCountryCode(currency.getCountryCode())==null)
		{
		Currency newCurrency = currencyRepo.save(currency);
		return newCurrency;
		}
		else
			throw new ConversionFactorAlreadyExistsException();
	}
	
	public double getConversionFactor(String countryCode)
	{
		Currency currency = currencyRepo.findCurrencyByCountryCode(countryCode);
		if(currency!=null)
			return currency.getConversionFactor();
		else 
		 throw new ConversionFactorNotFoundException();
		}
	
	public boolean updateCoversionFactor(Currency currency)
	{
		Currency existingCurrency = currencyRepo.findCurrencyByCountryCode(currency.getCountryCode());
		
		if(existingCurrency !=null)
		{
		Currency updatedCurrency = new Currency(existingCurrency.getId(),currency.getCurrency(),currency.getCountryCode(),currency.getConversionFactor());
		Currency newCurrency = currencyRepo.save(updatedCurrency);
		if(newCurrency != null)
			return true;
		else 
			throw new ConversionFactorNotUpdatedException();
		}
		else
			throw new ConversionFactorNotFoundException();
		
		
	}
	
}
