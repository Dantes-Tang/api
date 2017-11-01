package skillset;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsSite;
import com.capgemini.drms.service.DrmsSiteService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsSiteTest {
	@Autowired
	private DrmsSiteService drmsSiteService;	
	@Test
	public void insetDrmsSite(){
		DrmsSite drmsSite = new DrmsSite();
		drmsSite.setSiteId(4);
		drmsSite.setSiteName("hangzhou");
		drmsSiteService.insertDrmsSite(drmsSite);
	}
	@Test
	public void updateDrmsSite(){
		DrmsSite drmsSite = new DrmsSite();
	    drmsSite.setSiteId(1);
		drmsSite.setSiteName("beijing");
		drmsSiteService.updateDrmsSite(drmsSite);
	}
	@Test
	public void searchDrmsSites(){
		int siteId = 1;
		List<DrmsSite> drmsSites = drmsSiteService.searchDrmsSiteAll();
		for (DrmsSite drmsSite : drmsSites) {
			System.out.println(drmsSite.getSiteName()+"//////////"+drmsSite.getSiteId());
		}
			
	}
}
