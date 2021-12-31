package com.ibm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer>{

	double findConversionFactorByCountryCode(String countryCode);
	Currency findCurrencyByCountryCode(String countryCode);
}
