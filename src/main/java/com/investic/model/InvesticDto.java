package com.investic.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class InvesticDto {
	
	@NotEmpty(message = "firstName is a required field")
	private String firstName;
	@NotEmpty(message = "lastName is a required field")
	private String lastName;
	@Pattern(regexp="(^$|[0-9]{10})",message="Mobile number is invalid")
	private String  mobileNumber;
	@NotEmpty(message = "iDNumber is a required field")
	private String iDNumber;
	private String physicalAddress;
	
	public InvesticDto(String firstName,String lastName, String  mobileNumber, String iDNumber, String physicalAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.iDNumber = iDNumber;
		this.physicalAddress = physicalAddress;
	}
	
	@Override
	public String toString() {
		return "InvesticDto [firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber
				+ ", iDNumber=" + iDNumber + ", physicalAddress=" + physicalAddress + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String  getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String  mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getiDNumber() {
		return iDNumber;
	}
	public void setiDNumber(String iDNumber2) {
		this.iDNumber = iDNumber2;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

}
