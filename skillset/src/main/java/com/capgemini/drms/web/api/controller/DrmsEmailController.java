package com.capgemini.drms.web.api.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.capgemini.drms.model.EmailContent;
import com.capgemini.drms.util.VelocityMailUtil;

@Controller
@RequestMapping(value = "api/drmsEmail")
public class DrmsEmailController extends BaseController {
	@Autowired
	private VelocityMailUtil velocityMailUtil;

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody boolean sendEmail(
			@RequestBody EmailContent emailContent) {
		Map model = new HashMap();
		// String name =getCurrentUser().getUserName();
		// model.put("CM_Name",name);
		model.put("opnDate", emailContent.getOpnDate());
		model.put("capa", emailContent.getCapa());
		model.put("posTit", emailContent.getPosTit());
		model.put("desDsg", emailContent.getDesDsg());
		model.put("hirRes", emailContent.getHirRes());
		model.put("hcReq", emailContent.getHcReq());
		model.put("billDate", emailContent.getBillDate());
		model.put("wrkLoc", emailContent.getWrkLoc());
		model.put("cusInter", emailContent.getCusInter());
		model.put("projIntr", emailContent.getProjIntr());
		model.put("duty", emailContent.getDuty());
		model.put("other", emailContent.getOther());
		model.put("teches", emailContent.getTeches());
		model.put("langs", emailContent.getLangs());

		velocityMailUtil.sendMime(emailContent.getTo(), emailContent.getCc(),
				model, emailContent.getAttachName(),
				emailContent.getAttachPath());
		return true;
	}

	/**
	 * 具体的实现下载功能
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
    @RequestMapping(value="/fileUpload" , method = RequestMethod.POST )  

	public @ResponseBody String[] fileUpload(HttpServletRequest request,HttpServletResponse response){
		long startTime=System.currentTimeMillis();   //??????
		String fileNameAndPath [] =new String[2];
		
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){ //??request???????
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			Iterator<String> ite = multiRequest.getFileNames();
			 String path = request.getServletContext().getRealPath("/");
			 String realPath=path.substring(0, path.indexOf("DRMS"))+"DrmsStaticResource/attachments/";
			while(ite.hasNext()){
				MultipartFile file = multiRequest.getFile(ite.next());
				if(file!=null){
					File localFile = new File(realPath+file.getOriginalFilename());
					fileNameAndPath[0] = file.getName();
					fileNameAndPath[1] =realPath+file.getName();
					try {
						file.transferTo(localFile); //????????????????
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		long endTime=System.currentTimeMillis(); //??????
		System.out.println("?????????:"+(endTime-startTime));
		
		return fileNameAndPath;
	}
}  

	
		
	


