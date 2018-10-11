package com.silalahi.valentinus.app.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class Registrasi {

	@NotNull
	@NotEmpty
	private String nama;

	@Email
	private String email;

	@NotNull
	@NotEmpty
	private String hp;
}
