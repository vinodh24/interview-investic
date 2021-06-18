package com.investic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.investic.config.InvestecIntilizer;
import com.investic.model.InvesticDto;

/**
* @author  Vinodh Sangavaram
*/

@Service
public class InvestecService {

	public InvesticDto addInvestic(InvesticDto investicDto) throws Exception {
		InvestecIntilizer investecIntilizer=InvestecIntilizer.getInstance();
		return investecIntilizer.addInvestic(investicDto);
	}

	public InvesticDto findByInvestcId(String iDNumber) throws Exception {
		InvestecIntilizer investecIntilizer=InvestecIntilizer.getInstance();
		return investecIntilizer.getInvesticDtoID(iDNumber);
	}

	public InvesticDto updateInvestc(String iDNumber,InvesticDto investicDto) throws Exception {
		InvestecIntilizer investecIntilizer=InvestecIntilizer.getInstance();
		return investecIntilizer.updateInvesticDto(iDNumber, investicDto);
	}

	public List<InvesticDto> findByName(Integer name) {
		return null;
	}

	public List<InvesticDto> findByPhoneNumber(Integer number) {
		return null;
	}

}
