package com.silalahi.valentinus.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.Pendaftar;
import com.silalahi.valentinus.app.entity.Tagihan;

public interface TagihanDao extends PagingAndSortingRepository<Tagihan, String> {

	Long countByPendaftar(Pendaftar pendaftar);

	List<Tagihan> findByPendaftarOrderByTglTagihan(Pendaftar one);

	List<Tagihan> findByPendaftarOrderByTglTagihan(Pendaftar pendaftar, Pageable page);

	Page<Tagihan> findById(String tagihan, Pageable page);

	Tagihan findByPendaftar(Pendaftar p);

	Tagihan findByNoTagihan(String nomor);

}
