package com.silalahi.valentinus.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.Pendaftar;
import com.silalahi.valentinus.app.entity.User;

/*public interface PendaftaranDao extends PagingAndSortingRepository<Pendaftar, String> {
	Page<Pendaftar> findByNoRegContainingOrNamaContainingIgnoreCaseAndProgStudiNotNullOrderByNoReg(String nomor,
			String nama, Pageable page);

	Pendaftar findByUser(User user);

	Pendaftar findByNoReg(String nomor);

	Page<Pendaftar> findByNoRegContainingIgnoreCaseOrderByNoReg(String nomor, Pageable page);

	Page<Pendaftar> findByIdContainingIgnoreCaseOrderById(String idPendaftaran, Pageable page);

	List<Pendaftar> findByProgramStudiNotNull();

	Page<Pendaftar> findByProgramStudiNotNull(Pageable page);

	Long countPendaftarByProgramStudiNotNull();
}*/
