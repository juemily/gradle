package com.ejercicio.gradle.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.gradle.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Serializable >{
	

}
