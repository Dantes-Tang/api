package com.capgemini.drms.model;

public class AppDictionary {
	private int id;
	private String  dataModule;
	private String  dataCode;
	private String  dataName;
	private String  dataParent_Id;
	private String  priority;
	private String  description;
	private String  retired;
	private String  updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataModule() {
		return dataModule;
	}
	public void setDataModule(String dataModule) {
		this.dataModule = dataModule;
	}
	public String getDataCode() {
		return dataCode;
	}
	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getDataParent_Id() {
		return dataParent_Id;
	}
	public void setDataParent_Id(String dataParent_Id) {
		this.dataParent_Id = dataParent_Id;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRetired() {
		return retired;
	}
	public void setRetired(String retired) {
		this.retired = retired;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}