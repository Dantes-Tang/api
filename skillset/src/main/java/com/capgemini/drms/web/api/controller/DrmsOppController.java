package com.capgemini.drms.web.api.controller;

import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.DrmsOpp;
import com.capgemini.drms.service.DrmsOppService;

@Controller
@RequestMapping(value="/api/drmsOpp")
public class DrmsOppController {
	@Autowired
	DrmsOppService  drmsOppService;
	@RequestMapping(value="/get",method = RequestMethod.POST)
    public @ResponseBody List<DrmsOpp>  getDrmsOpp()
   {
	 return drmsOppService.getDrmsOpp() ;
   }
	@RequestMapping(value="/updateInsert",method = RequestMethod.POST)
	public @ResponseBody List<Boolean>  controllerSelect(@RequestBody List<DrmsOpp> list)
	{
    List<Boolean> l = new LinkedList<Boolean>();
    for(DrmsOpp drmsOpp:list){
           if(drmsOpp.getOppId()==0){
                 if (drmsOppService.insertDrmsOpp(drmsOpp) > 0){
                               l.add(true);
                        }else{
                               l.add(false);
                        }
           }else{
                 if (drmsOppService.updateDrmsOpp(drmsOpp) > 0){
                        l.add(true);
                 }else{
                        l.add(false);
                 }
           }
    }
    return l;
}
	
}
