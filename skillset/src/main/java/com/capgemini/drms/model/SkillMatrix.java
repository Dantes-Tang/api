package com.capgemini.drms.model;

public class SkillMatrix {

	private long id;
	private String username;
	private String fullName;
	private String skill;
	private String level;
	private String experience;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SkillMatrix [id=" + id + ", username=" + username
				+ ", fullName=" + fullName + ", skill=" + skill + ", level="
				+ level + ", experience=" + experience + "]";
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
