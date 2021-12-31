package com.ibm.controller;

import java.net.URI;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.entity.Currency;
import com.ibm.model.ManageConversionFactorSvcReq;
import com.ibm.model.ResponseBody;
import com.ibm.service.ManageConversionFactorSvc;

@RequestMapping("/conversionFactor")
@RestController
public class ManageConversionFactorController {

	@Autowired
	ManageConversionFactorSvc service;
	
	@PostMapping
	public ResponseEntity<Currency> addConversionFactor(@RequestBody ManageConversionFactorSvcReq req)
	{
		Currency currency = service.addConversionFactor(new Currency(req.getCurrency(),req.getCountryCode(),req.getConversionFactor()));
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{countryCode}").buildAndExpand(currency.getCountryCode()).toUri();
		
		return ResponseEntity.created(location).body(currency);
		}
	
	@GetMapping("/{countryCode}")
	public ResponseEntity<?> getConversionFactor(@PathVariable String countryCode)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getConversionFactor(countryCode));
	}
	
	@PutMapping()
	public ResponseEntity<?> updateConversionFactor(@RequestBody ManageConversionFactorSvcReq req)
	{
		service.updateCoversionFactor(new Currency(req.getCurrency(),req.getCountryCode(),req.getConversionFactor()));
		return ResponseEntity.status(HttpStatus.CREATED).body("Updated");	
	}
}
