package com.metinagan.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {
	
	@NotEmpty(message = "firstName alanı boş bırakılamaz")
	@NotNull(message = "firstName alanı boş olamaz")
	@Size(min = 3,max = 25, message = "İsim alanı 3 ile 25 karakter arasında olmalı.")
	private String firstName;
	
	@NotNull
	@NotEmpty
	@Size(min = 2,max = 25, message = "Soyisim alanı 2 ile 25 karakter arasında olmalı.")
	private String lastName;
	
	private Date birtOfDate;

	
}
