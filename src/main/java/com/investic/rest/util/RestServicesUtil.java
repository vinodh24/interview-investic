package com.investic.rest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
* @author  Vinodh Sangavaram
*/

public class RestServicesUtil {


	public static ResponseEntity<?> getSuccessGetResponse(Object entity) {
		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}


	public static ResponseEntity<?> getFailureResponseEntity(Object response) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	public static ResponseEntity<?> getFailureResponseEntity(HttpStatus httpStatus,Object response) {
		return ResponseEntity.status(httpStatus).body(response);
	}
}
