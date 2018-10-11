package com.silalahi.valentinus.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silalahi.valentinus.app.dao.RunningnumberDao;
import com.silalahi.valentinus.app.entity.RunningNumber;

@Service
public class RunningNumberService {

	private final Logger LOGGER = LoggerFactory.getLogger(RunningNumberService.class);

	@Autowired
	RunningnumberDao runningNumberDao;

	public RunningNumber generate(String nama) {
		RunningNumber rn = runningNumberDao.findByNama(nama);
		if (rn == null) {
			rn = new RunningNumber();
			rn.setNama(nama);
			rn.setNamorTerakhir(0L);
		}
		LOGGER.info("Angka Lama : {}", rn.getNamorTerakhir());
		rn.setNamorTerakhir(rn.getNamorTerakhir() + 1);
		runningNumberDao.save(rn);
		LOGGER.info("Angka baru : {}", rn.getNamorTerakhir());
		return rn;
	}

}
