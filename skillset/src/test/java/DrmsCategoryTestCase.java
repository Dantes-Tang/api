import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.drms.model.Category;
import com.capgemini.drms.service.DrmsCategoryService;

/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author jerqin, create on Feb 15, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-context.xml" })

public class DrmsCategoryTestCase
{
   @Autowired
    private DrmsCategoryService drmsCategoryService;
 
   @Test
   public void findAllCategories(){
       List<Category> categories = drmsCategoryService.findAllCategories();
       for (Category category : categories)
    {
        System.out.println(category.getName()+"   xxxxxxxxxxxxxxxxxxx");
        System.out.println(category.getParent()+"   xxxxxxxxxxxxxxxxxx");
        List<Category> chilrdenCategories = category.getChildren();
        for (Category category2 : chilrdenCategories)
        {
            System.out.println(category2.getName()+" xxxxxxxxxxxxxxxxx");
        } 
    }
   }

}
