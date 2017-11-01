
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.model.CapgUserRole;
import com.capgemini.drms.model.Country;
import com.capgemini.drms.model.Flexibility;
import com.capgemini.drms.model.Page;
import com.capgemini.drms.model.SearchModel;
import com.capgemini.drms.service.AppUserService;
import com.capgemini.drms.service.FlexibilityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class FlexibilityTestCase {

	@Autowired
	private FlexibilityService flexibilityService;
	@Autowired 
	private AppUserService appUserService;
	@Test
	public void searchChraUser() {
		SearchModel searchModel = new SearchModel();
//		searchModel.setCountry("guangzhou");
//		searchModel.setFullName("jay");
//		searchModel.setSkill("html");
		List<CapgUser> capgUsers = flexibilityService
				.searchCapgUser(searchModel);
		for (CapgUser user : capgUsers) {
			System.out.println("username:" + user.getUsername()
					+ "   fullName:" + user.getFullName());
		}

	}

	@Test
	public void getCountrys() {

		List<Country> countrys = flexibilityService.getCountrys();
		System.out
				.println("----------------------------------------------------"
						+ countrys.size());

	}

	@Test
	public void updateFlexibility() {
		Flexibility flexibility = new Flexibility();

		flexibility.setUsername("calvye");
		flexibility.setFullName("Calvin Ye");
		flexibility.setCountry("china");
		flexibility.setDuration("12");
		flexibilityService.updateFlexibility(flexibility);
	}

	@Test
	public void loadFlexibilityByUsername() {
		flexibilityService.loadFlexibilityByUsername("calvye");
	}

	@Test
	public void insertFlexibility() {
		Flexibility flexibility = new Flexibility();
		flexibility.setCountry("china");
		flexibility.setUsername("calvye");
		flexibility.setFullName("Calvin Ye");
		flexibility.setDuration("5");
		flexibilityService.insertFlexibility(flexibility);
	}

	@Test
	public void deleteFlexibility() {
		flexibilityService.deleteFlexibility("calvye");
	}
//
//	@Test
//	public void getLdapUser() {
//		CapgUser capgUser = new CapgUser();
//		capgUser.setUserName("calvye");
//
//		capgUser = flexibilityService.loadCapgUser(capgUser);
//		System.out.println("------------------" + capgUser.getFullName());
//	}
	@Test 
	public void findCapgUserRoleTest(){
		List<CapgUserRole> list=flexibilityService.findCapgUserRoles();
		for (CapgUserRole capgUser2 : list) {
			System.out.println();
			System.out.println(capgUser2.toString());
			System.out.println();
		}
		List<CapgUserRole> roleslist=flexibilityService.findCapgUserRole("c");
		for (CapgUserRole capgUserRole : roleslist) {
			System.out.println();
			System.out.println(capgUserRole.toString());
			System.out.println();
		}
		CapgUserRole roleIdList=flexibilityService.findCapgUserRoleID("jerry qin");
			System.out.println();
			System.out.println(roleIdList.toString());
			System.out.println();
			List<String> roleName=new ArrayList<String>();
			roleName.add("ROLE_ADMIN");
			roleName.add("ROLE_USER");
			roleName.add("ROLE_AP");
			System.out.println(roleName.toString());
			List<String>roleNameList=flexibilityService.findRoleIDByRoleName(roleName);
			System.out.println(roleNameList.toString());
			List<String> roleId=new ArrayList<>();
			roleId.add("1");
			roleId.add("2");
			roleId.add("3");
			List<String>list2 =new ArrayList<>();
			for (String string : roleId) {
				list2.add(string);
			}
			System.out.println("list2:"+list2.toString());
			System.out.println(roleId.toString());
			boolean b1=roleNameList.containsAll(roleId);
			System.out.println(b1);
			for (String string : roleId) {
				if (list2.contains(string)) {
					
				}
			}
			
	}
	@Test
	public void test2(){
		List<CapgUserRole> user=flexibilityService.findCapgUserRole("jerry qin");
		for (int i = 0; i < user.size(); i++) {
			CapgUserRole capgUserRole=user.get(i);
			//查找role_name对应的role_id
			List<String> roleNames=new ArrayList<>();
			roleNames.add("ROLE_AP");
			roleNames.add("ROLE_S");
			roleNames.add("ROLE_HR");
			List<String> roleIdList1=flexibilityService.findRoleIDByRoleName(roleNames);
			//查找fullName对应的role_id
			CapgUserRole capgUserRole1=flexibilityService.findCapgUserRoleID(capgUserRole.getFullName());
			CapgUserRole capgUserRole2=new CapgUserRole();
			capgUserRole2.setUserId(capgUserRole1.getUserId());
			for (String string : roleIdList1) {
				if (!capgUserRole1.getRoleId().contains(string)) {
					List<String> roles=new ArrayList<>();
					roles.add(string);
					capgUserRole2.setRoleId(roles);
					if (flexibilityService.insertCapgUserRole(capgUserRole2)>0) {
						System.out.println("插入成功");
				}
					}
				
				}
			
				
		}
	}
	@Test
	public void pageTest(){
		Page page=new Page();
		List<CapgUserRole> CapgUserlist=flexibilityService.findCapgUserRoles();
		List<Object> list=new ArrayList<>();
		for (CapgUserRole capgUserRole : CapgUserlist) {
			list.add(capgUserRole);
		}
		page.setList(list);
		
	}
	@Test
	public void searchOnSiteTest(){
		List<Country> searchAllOnSite = flexibilityService.serachOnSite();
		for(Country onSite:searchAllOnSite){
			System.out.println(onSite.getName()+","+onSite.getId()+","+onSite.getParent()+","+onSite.getChildren());
		}
	}
	@Test
	public void findCapgeUserFullName(){
		String emailString="hoi.wu@capgemini.com";
		String s1=appUserService.findFullName(emailString);
		System.out.println(s1);
	}
}

