package com.silalahi.valentinus.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Data
public class Pendaftar {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = ("uuid2"))
	private String id;

	@NotNull
	@NotEmpty
	private String nomorRegistrasi;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 150)
	private String nama;

	@Column(nullable = false)
	@NotNull
	private String noHp;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String negara;

	@ManyToOne
	@JoinColumn(name = "id_kabupaten_kota")
	private KabupatenKota kabupateKota;

	@Column(nullable = false)
	@NotNull
	@NotEmpty
	private String namaAsalSekolah;

	@Column(nullable = false)
	private String pemberiRekomendasi;

	@Column(nullable = false)
	private String namaPerekomendasi;

	@ManyToOne
	@JoinColumn(name = "id_program_studi")
	private ProgramStudi programStudi;

	@Column(nullable = false)
	private String konsentrasi;

	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;

	@Column(nullable = false)
	private String agama;
}
