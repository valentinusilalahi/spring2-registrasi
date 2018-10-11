package com.silalahi.valentinus.app.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.silalahi.valentinus.app.constants.AppConstants;
import com.silalahi.valentinus.app.dao.PendaftarDao;
import com.silalahi.valentinus.app.dao.RoleDao;
import com.silalahi.valentinus.app.dao.UserDao;
import com.silalahi.valentinus.app.dao.UserPasswordDao;
import com.silalahi.valentinus.app.dto.Registrasi;
import com.silalahi.valentinus.app.entity.KabupatenKota;
import com.silalahi.valentinus.app.entity.Pendaftar;
import com.silalahi.valentinus.app.entity.ProgramStudi;
import com.silalahi.valentinus.app.entity.Role;
import com.silalahi.valentinus.app.entity.RunningNumber;
import com.silalahi.valentinus.app.entity.User;
import com.silalahi.valentinus.app.entity.UserPassword;

@Service
@Transactional
public class RegistrasiService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrasiService.class);

	@Autowired private RunningNumberService runningNumberService;
	@Autowired private UserDao userDao;
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private UserPasswordDao userPasswordDao;
	@Autowired private RoleDao roleDao;
	@Autowired private PendaftarDao pendaftarDao;
	@Autowired private TagihanService tagihanService;
	@Autowired private NotifikasiService notifikasiService;

	public Pendaftar prosesPendaftaran(Registrasi registrasi, ProgramStudi ps, KabupatenKota kk) {

		Pendaftar p = new Pendaftar();
		p.setProgramStudi(ps);
		p.setKabupateKota(kk);

		BeanUtils.copyProperties(registrasi, p);

		System.out.println("id : " + registrasi.getId());

		if (!StringUtils.hasText(registrasi.getId())) {
			p.setNomorRegistrasi(generateNomorRegistrasi());
		} else {
			p.setNomorRegistrasi(registrasi.getNomorRegistrasi());
		}

		createUser(p);
		pendaftarDao.save(p);
		tagihanService.prosesTagihanPendaftaran(p);
		notifikasiService.kirimNotifikasiRegistrasi(p);
		return p;

	}

	private void createUser(Pendaftar p) {
		// TODO Auto-generated method stub
		Role rolePendaftar = roleDao.findOne(AppConstants.ID_ROLE_PENDAFTAR);
		User user = new User();
		user.setUsername(p.getNomorRegistrasi());
		user.setActive(false);
		user.setRole(rolePendaftar);
		userDao.save(user);

		UserPassword up = new UserPassword();
		up.setUser(user);
		up.setPassword(passwordEncoder.encode(RandomStringUtils.randomAlphabetic(6)));
		userPasswordDao.save(up);

		p.setUser(user);

	}

	private String generateNomorRegistrasi() {
		// TODO Auto-generated method stub
		String tanggalSekarang = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM"));
		RunningNumber terbaru = runningNumberService.generate(tanggalSekarang);

		LOGGER.debug("Tanggal Sekarang : {}", tanggalSekarang);
		LOGGER.debug("Nomor Terakhir : {}", terbaru.getNamorTerakhir());

		String nomorRegistrasi = tanggalSekarang + String.format("%04d", terbaru.getNamorTerakhir());
		LOGGER.debug("Nomor Registrasi : {}", nomorRegistrasi);

		return nomorRegistrasi;
	}

}
