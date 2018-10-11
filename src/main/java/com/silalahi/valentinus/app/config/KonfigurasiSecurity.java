package com.silalahi.valentinus.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class KonfigurasiSecurity extends WebSecurityConfigurerAdapter {
	private static final String SQL_LOGIN = "";
	private static final String SQL_PERMISSION = "";
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		super.configure(auth);
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(SQL_LOGIN)
		.authoritiesByUsernameQuery(SQL_PERMISSION)
		.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		http.authorizeRequests()
		.antMatchers("/sekolah/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/sekolah/form").hasAuthority("VIEW_MASTER")
		.antMatchers("/programstudi/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/periode/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/grade/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/biaya/jenis/form").hasAuthority("VIEW_MASTER")
		.antMatchers("/biaya/jenis/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/biaya/nilai/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/registrasi/list").hasAnyAuthority("VIEW_MASTER","VIEW_FINANCE")
		.antMatchers("/registrasi/detail/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/agen/list").hasAuthority("VIEW_MASTER")
		.antMatchers("/agen/form").hasAuthority("VIEW_MASTER")
		.antMatchers("/agen/tagihan/list").hasAuthority("VIEW_MASTER")
		.anyRequest().authenticated()
		.and().logout().permitAll()
		.and().formLogin().defaultSuccessUrl("/home")
		.loginPage("/login")
		.permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
		web.ignoring()
		.antMatchers("/registrasi/form")
		.antMatchers("/selesai")
		.antMatchers("/favicon.ico")
		.antMatchers("/api/kokabawal*")
		.antMatchers("/api/sekolah*")
		.antMatchers("/info")
		.antMatchers("/js/**")
		.antMatchers("/img/*")
		.antMatchers("/images/**")
		.antMatchers("/index")
		.antMatchers("/frontend/home")
		.antMatchers("/frontend/hasiltest/list")
		.antMatchers("/")
		.antMatchers("/css/**")
		.antMatchers("/kartu")
		.antMatchers("/suratKeterangan")
		.antMatchers("/formNimko")
		.antMatchers("/404")
		.antMatchers("/reset-sukses")
		.antMatchers("/confirm")
		.antMatchers("/reset")
		.antMatchers("/brosur/pei")
		.antMatchers("/brosur/mua")
		.antMatchers("/brosur/ai")
		.antMatchers("/brosur/bmi")
		.antMatchers("/brosur/ei")
		.antMatchers("/buku/ei")
		.antMatchers("/lib/**")
		.antMatchers("/registrasi/smart/list**");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(17);
	}
	
	
}
