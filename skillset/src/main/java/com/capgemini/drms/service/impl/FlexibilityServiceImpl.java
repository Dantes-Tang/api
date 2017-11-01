package com.capgemini.drms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Flags.Flag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DbUserDao;
import com.capgemini.drms.dao.FlexibilityDao;
import com.capgemini.drms.dao.LdapUserDao;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.CapgUserRole;
import com.capgemini.drms.model.Country;
import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.SearchModel;
import com.capgemini.drms.service.FlexibilityService;

@Service(value = "flexibilityService")
public class FlexibilityServiceImpl implements FlexibilityService {

	@Autowired
	private FlexibilityDao flexibilityDao;

	@Autowired
	private LdapUserDao ldapUserDao;
	@Autowired
	private DbUserDao dbUserDao;

	public List<CapgUser> searchCapgUser(SearchModel searchModel) {
		return flexibilityDao.searchCapgUser(searchModel);
	}

	public List<Country> getCountrys() {
		return flexibilityDao.loadCountry(0);
	}

	public void updateFlexibility(Flexibility flexibility) {
		flexibilityDao.updateFlexibility(flexibility);
	}

	public List<Flexibility> loadFlexibilityByUsername(String username) {
		return flexibilityDao.loadFlexibilityByUsername(username);
	}

	public void insertFlexibility(Flexibility flexibility) {
		flexibilityDao.insertFlexibility(flexibility);
	}

	public void insertFlexibility(List<Flexibility> flexibilityes) {
		if (flexibilityes != null && flexibilityes.size() > 0) {
			flexibilityDao
					.deleteFlexibility(flexibilityes.get(0).getUsername());
			for (Flexibility skill : flexibilityes) {
				insertFlexibility(skill);
			}
		}
	}

	public void deleteFlexibility(String username) {
		flexibilityDao.deleteFlexibility(username);
	}

	public List<CapgUser> loadCapgUserByName() {
		return dbUserDao.loadCapgUserByName();
	}

	/**
	 * functional description：deleteCapgUser with userName
	 * 
	 * @param userName
	 * @return
	 */
	public int deleteCapgUser(String fullName) {
		return dbUserDao.deleteCapgUser(fullName);
	}

	/**
	 * functional description：getCapgUser with userName
	 * 
	 * @param userName
	 * @return
	 */
	public CapgUser getCapgUser(String fullName) {
		return dbUserDao.getCapgUser(fullName);
	}

	/**
	 * functional description：updateCapgUsers
	 * 
	 * @param capgUser
	 * @return
	 */
	public int updateCapgUsers(CapgUser capgUser) {
		return dbUserDao.updateCapgUsers(capgUser);
	}

	/**
	 * functional description：findcCapgUsers
	 * 
	 * @param userName
	 * @return
	 */
	public List<CapgUser> findcCapgUsers(String userName) {
		return dbUserDao.findcCapgUsers(userName);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.drms.service.FlexibilityService#addOrUpdate(java.util.List)
	 * @author dantang 2/17/2017
	 */
	@Override
	public boolean addOrUpdate(List<Flexibility> flexibility) {

		boolean flag = false;
		List<Flexibility> countryInFles = new ArrayList<Flexibility>();
		List<String> cList = new ArrayList<>();

		Map<String, String> map = new HashMap<>();
		String country = new String();
		String duration = new String();
		for (Flexibility flexibilityItm : flexibility) {
			if (flexibilityItm.getDuration() == " "
					|| flexibilityItm.getCountry().equals(" ")) {
				country = flexibilityItm.getCountry();
				duration = flexibilityItm.getDuration();
				countryInFles = searchCountryByUserName(flexibilityItm
						.getUsername());
				for (int i = 0; i < countryInFles.size(); i++) {
					String s1 = countryInFles.get(i).getCountry();
					String s2 = countryInFles.get(i).getDuration();
					map.put(s1, s2);
					cList.add(s1);
				}
				if (!cList.contains(flexibilityItm.getCountry())) {
					insertFlexibility(flexibilityItm);
					continue;
				} else if (cList.contains(flexibilityItm.getCountry())) {
					for (Map.Entry<String, String> entry : map.entrySet()) {
						if (country.equals(entry.getKey())) {
							if (!(duration.equals(entry.getValue()))) {
								updateDuration(duration, flexibilityItm.getId());
								break;
							}
						}
					}
				}
			}
			flag = true;
		}
		return flag;
	}

	public List<CapgUserRole> findCapgUserRole(String fullName) {
		return dbUserDao.findCapgUserRole(fullName);

	};

	public List<CapgUserRole> findCapgUserRoles() {
		return dbUserDao.findCapgUserRoles();
	}

	@Override
	public List<Flexibility> searchCountryByUserName(String userName) {
		// TODO Auto-generated method stub
		return flexibilityDao.searchCountryByUserName(userName);
	}

	@Override
	public int updateDuration(String duration, long id) {
		// TODO Auto-generated method stub
		return flexibilityDao.updateDuration(duration, id);
	}

	@Override
	public CapgUserRole findCapgUserRoleID(String fullName) {
		// TODO Auto-generated method stub
		return dbUserDao.findCapgUserRoleID(fullName);
	}

	@Override
	public int insertCapgUserRole(CapgUserRole capgUserRole) {
		// TODO Auto-generated method stub
		return dbUserDao.insertCapgUserRole(capgUserRole);
	}

	@Override
	public List<String> findRoleIDByRoleName(List<String> roleName) {
		// TODO Auto-generated method stub
		return dbUserDao.findRoleIDByRoleName(roleName);
	}

	@Override
	public List<Country> serachOnSite() {
		// TODO Auto-generated method stub
		return flexibilityDao.searchOnSite();
	}

	public CapgUserRole findCapgUserRoleName(String fullName) {
		return dbUserDao.findCapgUserRoleName(fullName);
	};

	public int deleteCapgUserRole(CapgUserRole capgUserRole) {

		return dbUserDao.deleteCapgUserRole(capgUserRole);
	}

	@Override
	public int addCapgUserRoles(CapgUserRole capgUserRole) {
		String fullName = capgUserRole.getFullName();
		List<String> roleNameList = capgUserRole.getRoleName();
		List<String> roleId1 = 
				findRoleIDByRoleName(roleNameList);
		CapgUserRole capgUserRole1 = 
				findCapgUserRoleID(fullName);
		CapgUserRole capgUserRole2 = new CapgUserRole();
		capgUserRole2.setUserId(capgUserRole1.getUserId());
		for (String string : roleId1) {
			if (!capgUserRole1.getRoleId().contains(string)) {
				capgUserRole2.setRoleNo(string);
				insertCapgUserRole(capgUserRole2);
			}
		}
		return 1;
	}

	@Override
	public int updateCapgUserRoles(CapgUserRole capgUserRole) {
		String fullName1 = capgUserRole.getFullName();
		List<String> roleName1 = capgUserRole.getRoleName();
		CapgUserRole capgUserRole2 = findCapgUserRoleName(fullName1);
		List<String> roleName2 = capgUserRole2.getRoleName();
		String userId = capgUserRole2.getUserId();
		List<String> roleName3 = new ArrayList<>();
		CapgUserRole capgUserRole3 = new CapgUserRole();
		capgUserRole3.setUserId(userId);
		List<String> roleId1 = new ArrayList<String>();
		for (String string1 : roleName1) {
			if (!roleName2.contains(string1)) {
				roleName3.add(string1);
			}
		}
		if (roleName3.size() != 0) {
			roleId1 = findRoleIDByRoleName(roleName3);
			for (String string : roleId1) {
				capgUserRole3.setRoleNo(string);
				if (insertCapgUserRole(capgUserRole3) > 0) {
					System.out.println("InsertComplete");
				}
			}
		}
		List<String> roleName4 = new ArrayList<>();
		List<String> roleId2 = new ArrayList<>();
		for (String string2 : roleName2) {
			if (!roleName1.contains(string2)) {
				roleName4.add(string2);
			}
		}
		if (roleName4.size() != 0) {
			roleId2 =findRoleIDByRoleName(roleName4);
			for (String string3 : roleId2) {
				capgUserRole3.setRoleNo(string3);
				deleteCapgUserRole(capgUserRole3);
				System.out.println("DeleteComplete");
			}
		}
		return 1;
	};
}
