package com.silalahi.valentinus.app.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.ProgramStudi;

public interface ProgramStudiDao extends PagingAndSortingRepository<ProgramStudi, String> {

	Page<ProgramStudi> findByNamaContainingIgnoreCaseOrderByNama(String nama, Pageable page);

}
