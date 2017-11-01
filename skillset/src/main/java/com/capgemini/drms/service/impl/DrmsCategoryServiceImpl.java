/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.drms.dao.DrmsCategoryDao;
import com.capgemini.drms.model.Category;
import com.capgemini.drms.service.DrmsCategoryService;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author jerqin, create on Feb 15, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@Service(value="DrmsCategoryService")
public class DrmsCategoryServiceImpl implements DrmsCategoryService
{
    @Autowired
    public DrmsCategoryDao drmsCategoryDao; 
    @Override
    public List<Category> findAllCategories()
    {
        // TODO Auto-generated method stub
        return drmsCategoryDao.findAllCategories();
    }

 

}
