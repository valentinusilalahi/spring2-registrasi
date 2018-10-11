package com.silalahi.valentinus.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.silalahi.valentinus.app.entity.Role;

public interface RoleDao extends PagingAndSortingRepository<Role, String> {

}
