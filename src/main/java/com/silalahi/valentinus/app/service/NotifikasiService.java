package com.silalahi.valentinus.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silalahi.valentinus.app.dto.DataNotifikasiRegistrasi;
import com.silalahi.valentinus.app.dto.NotifikasiRegistrasi;
import com.silalahi.valentinus.app.dto.NotifikasiRegistrasi.NotifikasiRegistrasiBuilder;
import com.silalahi.valentinus.app.entity.Pendaftar;

@Service
public class NotifikasiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotifikasiService.class);

	@Value("${notifikasi.registrasi.konfigurasi.pendaftaran}")
	private String konfigurasiNotifikasiPendaftaran;
	@Value("${notifikasi.topic.notifikasi}")
	private String topicNotifikasi;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private ObjectMapper objectMapper;

	@Async
	public void kirimNotifikasiRegistrasi(Pendaftar p) {
		NotifikasiRegistrasiBuilder notif = NotifikasiRegistrasi.builder()
				.konfigurasi(konfigurasiNotifikasiPendaftaran)
				.email(p.getEmail())
				.mobile(p.getNoHp())
				.data(DataNotifikasiRegistrasi.builder()
						.nama(p.getNama())
						.nomor(p.getNomorRegistrasi())
						.noHp(p.getNoHp())
						.email(p.getEmail())
						.sekolah(p.getNamaAsalSekolah())
						.biaya("300." + p.getNomorRegistrasi().substring(p.getNomorRegistrasi().length() - 3))
						.keterangan("Biaya Registrasi")
						.rekening("Bank Syariah Mandiri 703194018 a.n STEI Tazkia")
						.namaKontak1("Valentinus")
						.nomorKontak1("085721937567")
						.namaKontak2("Furqon")
						.nomorKontak2("08561360444")
						.namaKontak3("Panitia Penerimaan Mahasiswa Baru")
						.nomorKontak3("humas@tazkia.ac.id")
						.build());
		
		try {
			kafkaTemplate.send(topicNotifikasi, objectMapper.writeValueAsString(notif));
		} catch (Exception e) {
			LOGGER.warn(e.getMessage(), e);
		}
		

	}

}
