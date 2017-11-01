package com.capgemini.drms.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsDemand;
import com.capgemini.drms.model.DrmsOpp;
import com.capgemini.drms.model.OppDmd;
import com.capgemini.drms.service.DrmsDemandService;
import com.capgemini.drms.service.DrmsOppService;

@Controller
@RequestMapping("/api/oppdmdmatrix")
public class OpportunityDemandController {
	
	@Autowired
	private DrmsOppService  drmsOppService;
	@Autowired
	private DrmsDemandService drmsDemandService;
	
	private List<OppDmd> matrixWired(List<DrmsOpp> oppos, List<DrmsDemand> dmds) {
		List<OppDmd> oppodmds = new ArrayList<OppDmd>();
		oppos.forEach(oppo -> {
			OppDmd oppdmd = new OppDmd();
			oppdmd.setOppo(oppo);
			oppodmds.add(oppdmd);
		});
		oppodmds.forEach(oppodmd -> {
			Integer oppId = oppodmd.oppo.getOppId();
			oppodmd.dmds = drmsDemandService.searchDrmsDemandById(oppId);
		});
		return oppodmds;
	} 
	
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public @ResponseBody List<OppDmd> getOppDmdMatrix(@RequestParam(value="input")Integer status) {
		
		/*List<DrmsOpp> filteredOpp = drmsOppService.getDrmsOppByStatus();
		List<DrmsOpp> oppo = drmsOppService.getDrmsOpp();
		List<DrmsDemand> demand = drmsDemandService.searchDemandsByStatus(0);*/
		List<OppDmd> oppdmds = new ArrayList<OppDmd>();		
		
		if(status == 1) {
			//filtered opp dmd
			List<DrmsOpp> filteredOpp = drmsOppService.getDrmsOppByStatus();
			List<DrmsDemand> demand = drmsDemandService.searchDemandsByStatus(1);
			oppdmds = matrixWired(filteredOpp, demand);
			//filtered
		} else if(status == 2) {
			//all opp dmd
			List<DrmsOpp> filteredOpp = drmsOppService.getDrmsOpp();
			List<DrmsDemand> demand = drmsDemandService.searchDemandsByStatus(0);
			oppdmds = matrixWired(filteredOpp, demand);
		}
		
		return oppdmds;
	}
}
