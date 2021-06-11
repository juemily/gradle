package com.ejercicio.gradle.service;

import java.util.List;

import com.ejercicio.gradle.dto.UserDto;

public interface UsersService {
	
	public abstract  List<UserDto> insertUser (UserDto user);

}
