package com.ibm.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.exception.ConversionFactorAlreadyExistsException;
import com.ibm.exception.ConversionFactorNotFoundException;
import com.ibm.exception.ConversionFactorNotUpdatedException;
import com.ibm.exception.CurrencyNotFoundException;
import com.ibm.model.ErrorResponse;

@RestControllerAdvice
public class ManageCurrencyFactorControllerAdvice {

	@ExceptionHandler(CurrencyNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCurrencyNotFoundException(CurrencyNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Error","Currency Not Found",new Date()));
	}
	
	@ExceptionHandler(ConversionFactorNotUpdatedException.class)
	public ResponseEntity<ErrorResponse> handleConversionFactorNotUpdatedException(ConversionFactorNotUpdatedException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(new ErrorResponse("Error","Conversion Factor Not Updated",new Date()));
	}
	
	@ExceptionHandler(ConversionFactorNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleConversionFactorNotFoundException(ConversionFactorNotFoundException e)
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("Error","Conversion Factor Not Found",new Date()));
	}
	
	@ExceptionHandler(ConversionFactorAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleConversionFactorAlreadyExistsException(ConversionFactorAlreadyExistsException e)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ErrorResponse("Error","Conversion factor Already Exists",new Date()));
	}
}
