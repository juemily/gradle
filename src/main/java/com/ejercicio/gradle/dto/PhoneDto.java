package com.ejercicio.gradle.dto;

import java.util.UUID;

import com.ejercicio.gradle.entity.Phone;

import lombok.Data;


@Data
public class PhoneDto {


	private String number;

	private String citycode;

	private String contrycode;



	public PhoneDto(String number, String cityCode, String countryCode) {
	
		this.number = number;
		this.citycode = cityCode;
		this.contrycode = countryCode;
	}
	
	public PhoneDto(Phone phone) {
		
		this.number = phone.getNumber();
		this.citycode = phone.getCitycode();
		this.contrycode = phone.getContrycode();
	}

	public PhoneDto() {
		
		// TODO Auto-generated constructor stub
	}
	

}
