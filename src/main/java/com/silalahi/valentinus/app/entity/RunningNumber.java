package com.silalahi.valentinus.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "running_number", uniqueConstraints = @UniqueConstraint(columnNames = { "nama", "nomor_terakhir" }))
public class RunningNumber implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "nama", nullable = false)
	@NotNull
	private String nama;

	@NotNull
	@Min(1)
	@Column(name = "nomor_terakhir", nullable = false)
	private Long namorTerakhir = 0L;

}
