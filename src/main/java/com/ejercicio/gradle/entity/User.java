package com.ejercicio.gradle.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;

import com.ejercicio.gradle.dto.PhoneDto;
import com.ejercicio.gradle.dto.UserDto;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private UUID userid;

	@Column(name = "name")
	@NotNull
	private String name;
	
	
	
	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "password")
	@NotNull
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Phone> phones = new ArrayList<>();
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}



	public User() {
		
	}
	
	

	public User(String name, String email, String password, List<Phone> phones) {

		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}
	

	

	public User (UserDto userDto) {
		
		
		
		List<Phone> phoneList = new ArrayList<Phone>();
		
		for (PhoneDto dto : userDto.getPhones()) {
			
			phoneList.add(new Phone(dto));
		}

		this.name = userDto.getName();
		this.email = userDto.getEmail();
		this.password = userDto.getPassword();
		this.phones = phoneList;
	}
	
			



}
