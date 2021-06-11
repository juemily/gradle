package com.ejercicio.gradle.dto;

import java.util.ArrayList;
import java.util.List;

import com.ejercicio.gradle.entity.Phone;
import com.ejercicio.gradle.entity.User;

import lombok.Data;


@Data
public class UserDto {

	private String name;
	
	private String email;

	private String password;

	private List<PhoneDto> phones ;
	
	private String error;
	
	

	
	public UserDto(String name, String email, String password, List<PhoneDto> phones, String errors) {
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
		this.error = errors;
	}

	public UserDto() {
	
		// TODO Auto-generated constructor stub
	}
	
	
public UserDto(User user) {
	
	List<PhoneDto> phoneList = new ArrayList<PhoneDto>();
	
	for (Phone dto : user.getPhones()) {
		
		phoneList.add(new PhoneDto(dto));
	}
		
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phones = phoneList;
	}
	
	

}
