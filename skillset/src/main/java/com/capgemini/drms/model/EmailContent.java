package com.capgemini.drms.model;

import java.util.List;

public class EmailContent {
	String to;
	String opnDate;
	String capa;
	String posTit;
	String desDsg;
	String hirRes;
	String hcReq;
	String billDate;
	String wrkLoc;
	String cusInter;
	String projIntr;
	String duty;
	String other;
	String cc;
	String attachPath;
	String attachName;
	List<EmailTeches> teches;
	List<EmailLangs> langs;
	public String getAttachPath() {
		return attachPath;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public List<EmailLangs> getLangs() {
		return langs;
	}

	public void setLangs(List<EmailLangs> langs) {
		this.langs = langs;
	}

	public List<EmailTeches> getTeches() {
		return teches;
	}

	public void setTeches(List<EmailTeches> teches) {
		this.teches = teches;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getOpnDate() {
		return opnDate;
	}

	public void setOpnDate(String opnDate) {
		this.opnDate = opnDate;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		this.capa = capa;
	}

	public String getPosTit() {
		return posTit;
	}

	public void setPosTit(String posTit) {
		this.posTit = posTit;
	}

	public String getDesDsg() {
		return desDsg;
	}

	public void setDesDsg(String desDsg) {
		this.desDsg = desDsg;
	}

	public String getHirRes() {
		return hirRes;
	}

	public void setHirRes(String hirRes) {
		this.hirRes = hirRes;
	}

	public String getHcReq() {
		return hcReq;
	}

	public void setHcReq(String hcReq) {
		this.hcReq = hcReq;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public String getWrkLoc() {
		return wrkLoc;
	}

	public void setWrkLoc(String wrkLoc) {
		this.wrkLoc = wrkLoc;
	}

	public String getCusInter() {
		return cusInter;
	}

	public void setCusInter(String cusInter) {
		this.cusInter = cusInter;
	}

	public String getProjIntr() {
		return projIntr;
	}

	public void setProjIntr(String projIntr) {
		this.projIntr = projIntr;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

}
