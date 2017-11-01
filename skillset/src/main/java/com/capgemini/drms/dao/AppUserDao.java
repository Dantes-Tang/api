package com.capgemini.drms.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDao {
	public String findFullName(String email);
}
