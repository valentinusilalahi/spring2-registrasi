package com.silalahi.valentinus.app.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.DetailPendaftar;
import com.silalahi.valentinus.app.entity.Pendaftar;

public interface DetailPendaftarDao extends PagingAndSortingRepository<DetailPendaftar, String> {
	DetailPendaftar findByPendaftar(Pendaftar p);

	Page<DetailPendaftar> findBPendaftarNoRegContainingOrPendaftarNamaContainingIgnoreCaseAndNimNotNullOrderByPendaftarNoReg(
			String nomor, String nim, String nama, Pageable page);

	Page<DetailPendaftar> findBNimNotNull(Pageable page);

	Long countDetailPendaftarByPendaftarNotNull();
}
