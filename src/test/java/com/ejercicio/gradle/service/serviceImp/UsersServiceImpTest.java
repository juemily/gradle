package com.ejercicio.gradle.service.serviceImp;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.ejercicio.gradle.dto.PhoneDto;
import com.ejercicio.gradle.dto.UserDto;
import com.ejercicio.gradle.service.impl.UsersServiceImp;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UsersServiceImpTest {
	
	

	
	

	
	@Autowired
	private UsersServiceImp usersServiceImp;
	
	
	@Test
	public void insertUser() throws Exception {
		
		 UserDto userDto = new UserDto();
		 PhoneDto phoneDto = new PhoneDto();
		 List<UserDto> userListDto = new ArrayList<UserDto>();
		 List<PhoneDto> phoneListDto = new ArrayList<PhoneDto>();
		 
		 phoneDto.setCitycode("1");
		 phoneDto.setContrycode("57");
		 phoneDto.setNumber("456789");
		 phoneListDto.add(phoneDto);
		 
		 userDto.setEmail("juan@rodriguez.org");
		 userDto.setName("algun nombre");
		 userDto.setPassword("algun string");
		 //userDto.setPhones(phoneListDto);
		 
		 when(usersServiceImp.insertUser(userDto)).thenReturn(userListDto);
		assertTrue(true);
		
	}
	

}
