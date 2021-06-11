package com.ejercicio.gradle.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ejercicio.gradle.dto.UserDto;
import com.ejercicio.gradle.service.impl.UsersServiceImp;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsersServiceImp usersServiceImp;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<UserDto>> saveUser (@RequestBody final UserDto user) {
		
		
		
		List<UserDto> retorno =usersServiceImp.insertUser(user);
		
		
		if (!retorno.isEmpty()) {
			return new ResponseEntity<List<UserDto>>(retorno,HttpStatus.CREATED);
			
		}
	
		return new ResponseEntity<List<UserDto>>(retorno,HttpStatus.BAD_REQUEST);
		
		
		
	}
}
