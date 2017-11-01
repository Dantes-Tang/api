/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.drms.model.Category;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author jerqin, create on Feb 15, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */
@Service
public interface DrmsCategoryService
{
    public List<Category> findAllCategories();
    
   
 
}
