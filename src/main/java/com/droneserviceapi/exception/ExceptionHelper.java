package com.droneserviceapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import com.droneserviceapi.data.payload.response.MessageResponse;

@ControllerAdvice
public class ExceptionHelper {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<MessageResponse> handleInvalidInputException(RuntimeException ex) {

		logger.error("Invalid Input Exception: ", ex.getMessage());
		
		System.out.println("exception is "+ ex.getMessage());

		return new ResponseEntity<MessageResponse>(new MessageResponse("Invalid Input"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { Unauthorized.class })

	public ResponseEntity<Object> handleUnauthorizedException(Unauthorized ex) {

		logger.error("Unauthorized Exception: ", ex.getMessage());

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);

	}

//	@ExceptionHandler(value = { BusinessException.class })
//
//	public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
//
//		logger.error("Business Exception: ", ex.getMessage());
//
//		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//
//	}

	@ExceptionHandler(value = { Exception.class })

	public ResponseEntity<Object> handleException(Exception ex) {

		logger.error("Exception: ", ex.getMessage());

		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
