package com.silalahi.valentinus.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class RegistrasiAkhir {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 150)
	private String nama;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String noHp;

	@Column(nullable = false, unique = true)
	@Email
	@NotNull
	@NotEmpty
	private String email;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String negara;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String kotaAsalSekolah;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String namaAsalSekolah;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String pemberiRekomendasi;

	@Column(nullable = false)
	private String namaPerekomendasi;

	@Column(nullable = false)
	private String programStrudiPilihan;

	@Column(nullable = false)
	private String konsentrasi;
}
