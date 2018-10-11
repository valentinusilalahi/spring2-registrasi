package com.silalahi.valentinus.app.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silalahi.valentinus.app.dto.DebiturRequest;
import com.silalahi.valentinus.app.entity.Pendaftar;

@Service
@Transactional
public class TagihanService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TagihanService.class);
	
	@Autowired private KafkaSender kafkaSender;

	public void prosesTagihanPendaftaran(Pendaftar p) {
		DebiturRequest request = DebiturRequest.builder().email(p.getEmail()).nama(p.getNama()).noHp(p.getNoHp())
				.nomorDebitur(p.getNomorRegistrasi()).build();
		kafkaSender.requestCreateDebitur(request);
	}

}
