package com.investic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.investic.exceptions.AlreadyExistsException;
import com.investic.model.InvesticDto;
import com.investic.rest.util.RestServicesUtil;
import com.investic.service.InvestecService;

@RestController
@RequestMapping(path = "/investec")
public class InvestecController {

	@Autowired
	private InvestecService investecService;

	@PostMapping(path= "/addInvestic", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> addInvestic(@RequestBody @Valid InvesticDto investicDto){
		try {
			return RestServicesUtil.getSuccessGetResponse(investecService.addInvestic(investicDto));
		} catch (AlreadyExistsException e) {
			return RestServicesUtil.getFailureResponseEntity(HttpStatus.FAILED_DEPENDENCY,e.getMessage());
		}catch (Exception e) {
			return RestServicesUtil.getFailureResponseEntity(e.getMessage());
		}
	}

	@GetMapping(path= "/findByInvestcId/{id}")
	public ResponseEntity<?> findByInvestcId(@PathVariable String id){
		try {
			return RestServicesUtil.getSuccessGetResponse(investecService.findByInvestcId(id));
		} catch (Exception e) {
			return RestServicesUtil.getFailureResponseEntity(e.getMessage());
		}
	}

	@PutMapping(path= "/updateInvestc/{iDNumber}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateInvestc(@RequestBody @Valid InvesticDto investicDto,@PathVariable String iDNumber){
		try {
			return RestServicesUtil.getSuccessGetResponse(investecService.updateInvestc(iDNumber,investicDto));
		} catch (Exception e) {
			return RestServicesUtil.getFailureResponseEntity(e.getMessage());

		}
	}

}
