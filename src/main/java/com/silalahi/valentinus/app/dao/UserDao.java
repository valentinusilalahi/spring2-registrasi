package com.silalahi.valentinus.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, String> {
	User findByUsername(String username);
}
