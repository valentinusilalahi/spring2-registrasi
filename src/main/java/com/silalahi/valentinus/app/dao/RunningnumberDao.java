package com.silalahi.valentinus.app.dao;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.RunningNumber;

public interface RunningnumberDao extends PagingAndSortingRepository<RunningNumber, Long> {

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	public RunningNumber findByNama(String nama);

}
