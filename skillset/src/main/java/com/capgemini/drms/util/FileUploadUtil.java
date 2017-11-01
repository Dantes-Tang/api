package com.capgemini.drms.util;

import java.io.File;  
import java.io.IOException;  
import java.util.List;  
  
import javax.servlet.ServletContext;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload; 
/** 
* @ClassName: FileUploadServlet 
* @Description: upload person face picture 
* @author winson luo
* @date Feb 14, 2017 11:50:11 AM 
*  
*/
public class FileUploadUtil {
	private static final long serialVersionUID = 1L;  
	  
    public static String upload(HttpServletRequest request) throws ServletException, IOException {  
          
        String fileName = null;  
        String realPath=null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
        
        
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        ServletContext servletContext = request.getServletContext();  
        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");  
        factory.setRepository(repository);  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {  
            List<FileItem> items = upload.parseRequest(request);  
            for(FileItem item : items) {  
                String type = item.getContentType();  
                if(type == null) {  
                    continue;  
                }   
                fileName = item.getName();  
                String path = request.getServletContext().getRealPath("/");
                realPath=path.substring(0, path.indexOf("DRMS"))+"DrmsStaticResource/images";
                File dir = new File(realPath);  
                File f = new File(dir, fileName);  
                if(!f.exists()) {  
                	f.createNewFile();  
                    item.write(f); 
                }  
                       
            }  
        } catch (FileUploadException e) {  
              
        } catch (Exception e) {  
             
        }  
        return fileName;  
    }  
}
