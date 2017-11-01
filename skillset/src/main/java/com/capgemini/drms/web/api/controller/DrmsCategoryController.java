/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping("/api/DrmsCategory")
public class DrmsCategoryController
{
    @Autowired
    private DrmsCategoryService drmsCategoryService;
    @RequestMapping(value = "/fianAllCategories", method = RequestMethod.POST)
    public @ResponseBody List<Category> findAllCategories(){
        return drmsCategoryService.findAllCategories();
    }
}
