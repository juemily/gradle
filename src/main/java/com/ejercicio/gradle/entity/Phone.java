package com.ejercicio.gradle.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.ejercicio.gradle.dto.PhoneDto;
import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name= "phones")
public class Phone {

		@Id
		@GeneratedValue
		private UUID phoneid;
		
		@Column(name = "userid")
		@JoinColumn(name = "userid")
		private String userid;
		
		@Column(name = "number")
		@NotNull
		private String number;
		
		@Column(name = "citycode")
		private String citycode;
		
		@Column (name= "contrycode")
		private String contrycode;

		

		public Phone() {
			
		}

		public Phone(String number, String cityCode, String countryCode) {
		
			this.number = number;
			this.citycode = cityCode;
			this.contrycode = countryCode;
		}

		public Phone(PhoneDto dto) {
			this.number = dto.getNumber();
			this.citycode = dto.getCitycode();
			this.contrycode = dto.getContrycode();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
		
		
		
		
		
		
	

}
