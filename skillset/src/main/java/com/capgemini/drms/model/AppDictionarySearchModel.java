package com.capgemini.drms.model;

public class AppDictionarySearchModel {
	
	private int     id;
	private String  dataName;
	private String  dataCode;
	private String  dataModule;
	private String  priority;
	private String  description;
	private String  retired;
	private String  dataParent_Id;
	private String  roleName;
	private String  updateDate;
	

	
    public String getDataParent_Id() {
		return dataParent_Id;
	}
	public void setDataParent_Id(String dataParent_Id) {
		this.dataParent_Id = dataParent_Id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getDataCode() {
		return dataCode;
	}
	public void setDataCode(String dataCode) {
		this.dataCode = dataCode;
	}
	public String getDataModule() {
		return dataModule;
	}
	public void setDataModule(String dataModule) {
		this.dataModule = dataModule;
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