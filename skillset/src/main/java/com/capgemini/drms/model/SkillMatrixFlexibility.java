package com.capgemini.drms.model;

import java.util.List;

public class SkillMatrixFlexibility {
private String fullName;
private List<SkillMatrix> skillMatrix;
public List<SkillMatrix> getSkillMatrix() {
	return skillMatrix;
}
public void setSkillMatrix(List<SkillMatrix> skillMatrix) {
	this.skillMatrix = skillMatrix;
}
public List<Flexibility> getFlexibility() {
	return flexibility;
}
public void setFlexibility(List<Flexibility> flexibility) {
	this.flexibility = flexibility;
}


private List<Flexibility> flexibility;
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
@Override
public String toString() {
	return "SkillMatrixFlexibility [fullName=" + fullName + ", skillMatrix="
			+ skillMatrix + ", flexibility=" + flexibility + "]";
}




}
