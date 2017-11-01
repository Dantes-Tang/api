package com.capgemini.drms.model;

public class DrmsResource {
	
	private int resourceId;
	private String resourceName;
	private String username;
	private DrmsCapability drmsCapability;
	private DrmsDesigation drmsDesigation;
	private String name;


	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public DrmsCapability getDrmsCapability()
    {
        return drmsCapability;
    }

    public void setDrmsCapability(DrmsCapability drmsCapability)
    {
        this.drmsCapability = drmsCapability;
    }

    public DrmsDesigation getDrmsDesigation()
    {
        return drmsDesigation;
    }

    public void setDrmsDesigation(DrmsDesigation drmsDesigation)
    {
        this.drmsDesigation = drmsDesigation;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

	

}
