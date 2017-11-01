package com.capgemini.drms.model;

import java.util.List;

public class OppDmd {
	
	public DrmsOpp oppo;
	public List<DrmsDemand> dmds;
	
	public DrmsOpp getOppo() {
		return oppo;
	}
	public void setOppo(DrmsOpp oppo) {
		this.oppo = oppo;
	}
	public List<DrmsDemand> getDmds() {
		return dmds;
	}
	public void setDmds(List<DrmsDemand> dmds) {
		this.dmds = dmds;
	}
	
	
}
