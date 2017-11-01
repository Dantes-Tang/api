package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.AppUserDao;
import com.capgemini.drms.dao.UserPermissionDao;
import com.capgemini.drms.dao.impl.LdapUserDaoImpl;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.service.AppUserService;

@Service(value = "AppUserService")
public class AppUserServiceImpl implements AppUserService {
	@Autowired
	private AppUserDao appUserDao;
	@Autowired
	private LdapUserDaoImpl ldapUserDaoImpl;
	@Autowired
	private UserPermissionDao userPermissionDao;

	public String findFullName(String email) {
		String fullName = appUserDao.findFullName(email);
		if (!(fullName == null)) {
			return appUserDao.findFullName(email);
		} else {
			CapgUser capgUser = ldapUserDaoImpl.findLdapUserByEmail(email);
			if (capgUser.getFirstName() != null
					&& capgUser.getLastName() != null) {
				System.out.println(capgUser.toString());
				capgUser.setFacePic("upload.png");
				System.out.println(capgUser.toString());
				userPermissionDao.addCapgUser(capgUser);
				List<String> idList = userPermissionDao
						.findIDByUserName(capgUser.getUsername());
				String id = idList.get(0);
				userPermissionDao.addCapgUserRole(id);
				return appUserDao.findFullName(email);
			}
			/* String s1="本公司不存在该用户"; */
			return "";
		}

	}

}
