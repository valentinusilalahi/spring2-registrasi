package com.silalahi.valentinus.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.KabupatenKota;
import com.silalahi.valentinus.app.entity.Provinsi;

public interface KabupatenKotaDao extends PagingAndSortingRepository<KabupatenKota, String> {

	List<KabupatenKota> findByProvinsiAndNameContainingIgnoreCaseOrderByNama(Provinsi p, String nama);

	List<KabupatenKota> findByNamaContainingIgnoreCaseOrderByNama(String nama);

	Page<KabupatenKota> findByNamaContainingIgnoreCaseOrderById(String id, Pageable page);

}
