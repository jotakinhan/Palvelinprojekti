package com.jotakinhan.Palvelinprojekti.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);//repository for saving users
}