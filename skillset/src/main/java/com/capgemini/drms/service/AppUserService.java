package com.capgemini.drms.service;

import org.springframework.stereotype.Repository;

@Repository
public interface AppUserService {
	public String findFullName(String email);
}
