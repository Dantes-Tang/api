package com.capgemini.drms.web.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.model.Category;
import com.capgemini.drms.model.SkillMatrix;
import com.capgemini.drms.model.SkillMatrixFlexibility;
import com.capgemini.drms.service.DrmsSkillFlexibilityService;
import com.capgemini.drms.service.SkillMatrixService;

@Controller
@RequestMapping("/api/skillmatrix")
public class SkillMatrixController extends BaseController
{

    private static final Log logger = LogFactory.getLog(SkillMatrixController.class);

    @Autowired
    private SkillMatrixService skillMatrixService;
    @Autowired
    private DrmsSkillFlexibilityService drmsSkillFlexibilityService;
    

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody List<SkillMatrix> add(@RequestBody List<SkillMatrix> skillMatrixes, HttpServletRequest request)
    {

        skillMatrixService.insertSkillMatrix(skillMatrixes);

        return skillMatrixService.loadSkillMatrixByUsername(getCurrentUser().getUserName());
    }

    @RequestMapping(value = "/getCategorys", method = RequestMethod.GET)
    public @ResponseBody List<Category> getCategorys()
    {

        return skillMatrixService.getCategorys();

    }

    
    @RequestMapping(value = "/getSkillMatrix", method = RequestMethod.GET)
    public @ResponseBody List<SkillMatrix> getSkillMatrix(@RequestParam String username)
    {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        username = userDetails.getUsername();

        return skillMatrixService.loadSkillMatrixByUsername(username);
    }

    @RequestMapping(value = "/updateOrAdd", method = RequestMethod.POST)
    public @ResponseBody void updateorAdd(@RequestBody List<SkillMatrix>  skillMatrixs)
    {

        
       /* UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();*/
        
        List<SkillMatrix> existSkillMatrixs = skillMatrixService.loadSkillMatrixByUsername("healiu");
        boolean isExist = true;
        for (SkillMatrix skillMatrix : skillMatrixs)
        {
            for (SkillMatrix existMatrix : existSkillMatrixs)
            {
                System.out.println("aaaaaaaaaaaaa");
                if(!skillMatrix.getSkill().isEmpty()&&existMatrix.getSkill().equals(skillMatrix.getSkill())&&skillMatrix.getLevel()!=null&&skillMatrix.getSkill()!=null&&skillMatrix.getExperience()!=null){
                  
                   skillMatrixService.updateSkillMatrix(skillMatrix);
                   isExist = false;
                    break;
                }
            }
            if(isExist){
                
                if(skillMatrix.getLevel()!=null&&skillMatrix.getExperience()!=null&&!skillMatrix.getLevel().isEmpty()&&!skillMatrix.getSkill().isEmpty()&&!skillMatrix.getExperience().isEmpty()){                
                    skillMatrixService.insertSkillMatrix(skillMatrix);
                }
            }
            isExist = true;
        }

    }

    /**
     * @author hongwu
     * @return user's information 
     */
    @RequestMapping(value = "/getSkillFlexibility", method = RequestMethod.GET)
    public @ResponseBody List<SkillMatrixFlexibility> findUserInformation()
    {
        List<String> fullNameList = drmsSkillFlexibilityService.findFullName();
        List<SkillMatrixFlexibility> skillMatrixFlexibilities = new ArrayList<>();
        for (int i = 0; i < fullNameList.size(); i++)
        {
            String string = fullNameList.get(i);
            SkillMatrixFlexibility skillMatrixFlexibility = new SkillMatrixFlexibility();
            skillMatrixFlexibility.setFullName(string);
            skillMatrixFlexibility.setFlexibility(drmsSkillFlexibilityService.findFlexibility(skillMatrixFlexibility
                    .getFullName()));
            skillMatrixFlexibility.setSkillMatrix(drmsSkillFlexibilityService.findSkillMatrix(skillMatrixFlexibility
                    .getFullName()));
            skillMatrixFlexibilities.add(skillMatrixFlexibility);
            System.out.println(skillMatrixFlexibilities.toString());
        }
        return skillMatrixFlexibilities;
    }
}
