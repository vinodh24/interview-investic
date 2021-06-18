package com.investic.config;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.investic.exceptions.AlreadyExistsException;
import com.investic.model.InvesticDto;

/**
* @author  Vinodh Sangavaram
*/

public class InvestecIntilizer{

	private static final Logger log = LoggerFactory.getLogger(InvestecIntilizer.class);

	private static InvestecIntilizer instance = null;
	private List<InvesticDto> investics;
	
	private InvestecIntilizer() {
		investics=new ArrayList<InvesticDto>();
		log.info("afterPropertiesSet in   InvestecIntilizer"+investics);
	}

	public static InvestecIntilizer getInstance() {
		if (instance == null) {
			instance = new InvestecIntilizer();
			log.info("instance object in   InvestecIntilizer"+instance);
		}
		return instance;
	}

	public InvesticDto addInvestic(InvesticDto investicDto) throws Exception {
		boolean var = investics.stream().anyMatch(element -> (element.getMobileNumber().equalsIgnoreCase(investicDto.getMobileNumber()))&&(element.getiDNumber().equalsIgnoreCase(investicDto.getiDNumber())));
		log.info("var in InvestecIntilizer"+var);
		if(!var) {
			investics.add(investicDto);	
		}else {
			 throw new AlreadyExistsException("Already presented object");
		}
		return investicDto;
	}

	public InvesticDto getInvesticDtoID(String iDNumber) throws Exception {
			return investics.stream().filter(s->s.getiDNumber().equalsIgnoreCase(iDNumber)).findAny().orElseThrow(() -> new IllegalArgumentException("No Object found with the iDNumber: "+ iDNumber));
	}

	public InvesticDto updateInvesticDto(String iDNumber,InvesticDto newObject) throws Exception {
		boolean var = investics.stream().anyMatch(element -> element.getiDNumber().equalsIgnoreCase(iDNumber));
		if(var) {
			InvesticDto curentObject=getInvesticDtoID(iDNumber);
			newObject=updateValues(curentObject,newObject);
			removeOldObject(curentObject);
			investics.add(newObject);	
		}else {
			 throw new Exception("problem ocuure while updating object");
		}
		return newObject;
	}

	private void removeOldObject(InvesticDto curentObject) {
		investics.removeIf(element -> element.getiDNumber().equalsIgnoreCase(curentObject.getiDNumber()));
	}

	private InvesticDto updateValues(InvesticDto curentObject, InvesticDto newObject) {
		if(StringUtils.isEmpty(newObject.getFirstName())) {
			newObject.setFirstName(curentObject.getFirstName());	
		}
		if(StringUtils.isEmpty(newObject.getLastName())) {
			newObject.setLastName(curentObject.getLastName());	
		}
		if(StringUtils.isEmpty(newObject.getMobileNumber())) {
			newObject.setMobileNumber(curentObject.getMobileNumber());	
		}
		if(StringUtils.isEmpty(newObject.getPhysicalAddress())) {
			newObject.setPhysicalAddress(curentObject.getPhysicalAddress());	
		}
		return newObject;	
	}

}
