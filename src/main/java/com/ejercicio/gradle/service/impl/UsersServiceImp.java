package com.ejercicio.gradle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.ejercicio.gradle.dto.PhoneDto;
import com.ejercicio.gradle.dto.UserDto;
import com.ejercicio.gradle.entity.Phone;
import com.ejercicio.gradle.entity.User;
import com.ejercicio.gradle.repository.UsersRepository;
import com.ejercicio.gradle.service.UsersService;

import lombok.SneakyThrows;

@Service
public class UsersServiceImp implements UsersService {

	

	@Autowired
	private UsersRepository usersRepository;

	@Override
	@SneakyThrows
	public List<UserDto> insertUser(UserDto user) {
		User userEntity = new User();

		List<User> userList = new ArrayList<User>();
		List<Phone> phoneList = new ArrayList<Phone>();
		List<UserDto> userListDto = new ArrayList<UserDto>();
		UserDto erroUser = new UserDto(); 
		
	
		
		try {
			
			if (!validaEmail(user.getEmail().toLowerCase())) {
				
				erroUser.setError("Email incorrecto");
				throw new Exception("Email incorrecto");
			}
			
			
			for (PhoneDto dto : user.getPhones()) {

				phoneList.add(new Phone(dto));
			}

			userEntity.setName(user.getName());
			userEntity.setEmail(user.getEmail().toLowerCase());
			userEntity.setPassword(user.getPassword());
			userEntity.setPhones(phoneList);

			usersRepository.save(userEntity);

			userList = usersRepository.findAll();

			for (User userD : userList) {

				userListDto.add(new UserDto(userD));
			}
			
		} catch (Exception e) {
			 userListDto = new ArrayList<UserDto>();
			 if(erroUser.getError() == null ) {
				 erroUser.setError("Body mal formado");
			 }
				 
			 userListDto.add(erroUser);
			 
			 
		}

		

		return userListDto;
	}
	
	
	 public static Boolean validaEmail (String email) {
		 
			Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
			Matcher matcher = pattern.matcher(email);
			return matcher.matches();
		}

}
