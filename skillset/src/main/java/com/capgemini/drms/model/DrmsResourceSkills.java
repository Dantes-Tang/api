/*
 * Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights reserved.
 * Use is subject to license terms.
 */

package com.capgemini.drms.model;

import java.util.List;

//TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author hongwu, create on Feb 13, 2017
 * Revision History:
 *      TODO Revised by XXXX on 201x/xx/xx, modified xxx
 */

public class DrmsResourceSkills {
private String resourceId;
private String name;
private String resourceName;
private List<SkillMatrix> skills;
private List<Flexibility> sites;
private List<String> desigation;


public String getResourceName() {
	return resourceName;
}
public void setResourceName(String resourceName) {
	this.resourceName = resourceName;
}
public List<SkillMatrix> getSkills() {
	return skills;
}

public void setSkills(List<SkillMatrix> skills) {
	this.skills = skills;
}

public String getResourceId() {
	return resourceId;
}
public void setResourceId(String resourceId) {
	this.resourceId = resourceId;
}
public List<Flexibility> getSites() {
	return sites;
}
public void setSites(List<Flexibility> sites) {
	this.sites = sites;
}



public List<String> getDesigation() {
	return desigation;
}
public void setDesigation(List<String> desigation) {
	this.desigation = desigation;
}
public String getName()
{
    return name;
}
public void setName(String name)
{
    this.name = name;
}
@Override
public String toString() {
	return "DrmsResourceSkills [resourceId=" + resourceId + ", name=" + name
			+ ", resourceName=" + resourceName + ", skills=" + skills
			+ ", sites=" + sites + ", desigation=" + desigation + "]";
}


}
