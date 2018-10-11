package com.silalahi.valentinus.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity @Data
public class DetailPendaftar {
	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid", strategy="uuid2")
	private String id;
	
	@NotNull
	@ManyToOne @JoinColumn(name="id_pendaftar")
	private Pendaftar pendaftar;
	
	@Column(nullable=false)
	@NotNull
	@NotEmpty
	private String tempatLahir;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	@Column(columnDefinition="DATE")
	private LocalDate tanggalLahir;
	
	@NotNull
	@NotEmpty
	private String jenisKelamin;
	
	@NotNull
    @NotEmpty
    @Size(max = 2)
    private String golonganDarah;

    @NotNull
    @NotEmpty
    private String noKtp;

    @NotNull
    @NotEmpty
    private String alamatRumah;

    @NotNull
    @NotEmpty
    private String provinsi;

    @NotNull
    @NotEmpty
    private String kokab;

    @NotNull
    @NotEmpty
    private String kodePos;

    @NotNull
    @NotEmpty
    private String noHp;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String asalSekolah;

    @NotNull
    @NotEmpty
    private String jurusanSekolah;

    private String nisn;

    @NotNull
    @NotEmpty
    private String tahunLulusSekolah;

    private String pekerjaanPribadi;

    private String penghasilanPribadi;

    @NotNull
    @NotEmpty
    private String statusSipil;

    @NotNull
    @NotEmpty
    private String namaAyah;

    @NotNull
    @NotEmpty
    private String agamaAyah;

    @NotNull
    @NotEmpty
    private String pendidikanAyah;

    @NotNull
    @NotEmpty
    private String pekerjaanAyah;

    @NotNull
    @NotEmpty
    private String namaIbu;

    @NotNull
    @NotEmpty
    private String agamaIbu;

    @NotNull
    @NotEmpty
    private String pendidikanIbu;

    @NotNull
    @NotEmpty
    private String pekerjaanIbu;

    @NotNull
    @NotEmpty
    private String alamatOrangtua;

    @NotNull
    @NotEmpty
    private String kokabOrangtua;

    @NotNull
    @NotEmpty
    private String nohpOrangtua;

    private String emailOrangtua;

    @NotNull
    @NotEmpty
    private String penghasilanOrangtua;

    @NotNull
    @NotEmpty
    private String jumlahTanggungan;

    @NotNull
    @NotEmpty
    private String rencanaBiaya;

    @Enumerated(EnumType.STRING)
    private JenisTest jenisTest;

    private String nim;
	
}
