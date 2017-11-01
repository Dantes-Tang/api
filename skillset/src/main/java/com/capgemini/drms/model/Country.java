package com.capgemini.drms.model;

import java.util.List;

public class Country {

	private long id;
	private String name;
	private String description;
	private List<Country> children;
	private long parent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Country> getChildren() {
		return children;
	}

	public void setChildren(List<Country> children) {
		this.children = children;
	}

	public long getParent() {
		return parent;
	}

	public void setParent(long parent) {
		this.parent = parent;
	}

}
