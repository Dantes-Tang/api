import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.DrmsResource;
import com.capgemini.drms.service.DrmsResourceService;

/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author jerqin, create on Mar 7, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })
public class DrmsResourceTestCase
{
    private DrmsResourceService drmsResourceService;
    @Test
    public void test()
    {
        List<DrmsResource> drmsResources = drmsResourceService.searchDrmsResourceAll();
        for (DrmsResource drmsResource : drmsResources)
        {
            System.out.println(drmsResource.getName());
        }
    }

}
