package com.silalahi.valentinus.app.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Tagihan {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pendaftar")
	private Pendaftar pendaftar;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_jenisbiaya")
	private JenisBiaya jenisBiaya;

	@NotNull
	@NotEmpty
	private String nomorTagihan;

	@NotNull
	@Column(columnDefinition = "DATE")
	private LocalDate tanggalTagihan;

	@NotNull
	@NotEmpty
	private String keterangan;

	@NotNull
	@Min(0)
	private BigDecimal nilai;

	@NotNull
	private Boolean lunas = Boolean.FALSE;
}
