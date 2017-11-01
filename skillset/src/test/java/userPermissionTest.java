import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.service.UserPermissionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class userPermissionTest {
	@Autowired
	private UserPermissionService userPermissionService;

	@Test
	public void test1() {
		List<String> a = userPermissionService.findUserPermission("senhu");
		System.out.println(a.toString());

	}

	@Test
	public void test2() {
		long startTime = System.currentTimeMillis();
		List<Map<String,String>> b = userPermissionService.findUser("senhu");
		System.out.println(b.toString());
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		if(b.size()==0){
			//userPermissionService.addCapgUser("senhu","222");
			userPermissionService.addCapgUserRole(userPermissionService
					.findIDByUserName("senhu").get(0));
			long start = System.currentTimeMillis();
			List<Map<String,String>> c = userPermissionService.findUserInformation("senhu");
			System.out.println(c.toString());
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			long s=System.currentTimeMillis();
			List<Map<String, String>>d=userPermissionService.findUser("senhu");
			System.out.println(d.toString());
			long e=System.currentTimeMillis();
			System.out.println(e-s);
			return;
		};
		long s=System.currentTimeMillis();
		List<Map<String, String>> d=userPermissionService.findUser("senhu");
		System.out.println(d.toString());
		long e=System.currentTimeMillis();
		System.out.println(e-s);
	}

	@Test
	public void test3() {
		CapgUser user = new CapgUser();
		user.setUserName("zhihuang");
		List<String> s = userPermissionService.findIDByUserName(user
				.getUserName());
		System.out.println(s.toString());
	}

	@Test
	public void test4() {
		userPermissionService.addCapgUserRole(userPermissionService
				.findIDByUserName("senhu").get(0));
	}
	@Test
	public void test5() {
		//userPermissionService.addCapgUser("winson","hahah");
	}
}
