package com.silalahi.valentinus.app.dao;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.User;
import com.silalahi.valentinus.app.entity.UserPassword;

public interface UserPasswordDao extends PagingAndSortingRepository<UserPassword, String> {

	UserPassword findByUser(User user);

	Optional<UserPassword> findById(String id);

}
