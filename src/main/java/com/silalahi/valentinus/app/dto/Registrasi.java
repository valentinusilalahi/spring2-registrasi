package com.silalahi.valentinus.app.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.silalahi.valentinus.app.entity.User;

import lombok.Data;

@Data
public class Registrasi {

	private String id;
	private String nomorRegistrasi;

	@NotNull
	@NotEmpty
	private String nama;

	@Email
	private String email;

	private String noHp;
	private String pemberiRekomendasi;
	private String namaPerekomendasi;
	private String negara;
	private String idKabupatenKota;
	private String namaAsalSekolah;
	private String programStudi;
	private String konsentrasi;
	private User user;
	private String agama;

}
