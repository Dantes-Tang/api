package com.capgemini.drms.web.ldap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.capgemini.drms.service.DrmsUrlAndRoleService;
  
  
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {   
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();   
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    @Autowired
    private DrmsUrlAndRoleService drmsUrlAndRoleService ;
   
    
   /* //tomcat启动时实例化一次  
    public MyInvocationSecurityMetadataSource() {  
        
    	
    	loadResourceDefine();    
        }     
    //tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系  
    private void loadResourceDefine() {  
    	
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  //建立这样的一个用来存放url对应的ROLE们
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();   //ROLE集合
        ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");  
        atts.add(ca); 
        resourceMap.put("http://localhost:8080/DRMS/index.html#/opps/detail-pc", atts);
        ConfigAttribute ca_user = new SecurityConfig("ROLE_USER");
        atts.add(ca_user);
        resourceMap.put("/index.html", atts);
       
        Collection<ConfigAttribute> attsno =new ArrayList<ConfigAttribute>();  
        ConfigAttribute cano = new SecurityConfig("ROLE_NO");  
        attsno.add(	cano);  
        resourceMap.put("/other.jsp", attsno);     
        
        }    
      
    //参数是要访问的url，返回这个url对于的所有权限（或角色）  
*/    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {   
    	
		
	
		
		if(resourceMap == null){
			
			//循环取出role放入configAttribute if ，和URL放入map存入
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	
			List<String> alLUrl =  drmsUrlAndRoleService.findAllUrl();
			Collection<ConfigAttribute> atts = null;
			for (String url : alLUrl) {
				
				atts = new ArrayList<ConfigAttribute>();
				List<String> roles  = drmsUrlAndRoleService.findAllRoleByUrl(url);//url对应的所有的权限
				for (String role : roles) {
					ConfigAttribute ca = new SecurityConfig(role);
					atts.add(ca);	
				}
				resourceMap.put(url, atts);
			}
			ConfigAttribute ca_admin = new SecurityConfig("ROLE_ADMIN");
			ConfigAttribute ca_user = new SecurityConfig("ROLE_USER");
			atts.add(ca_user);
			atts.add(ca_admin);
			resourceMap.put("/index.html", atts);
	
			
		}
    	
    
	// 将参数转为url   
		String url = ((FilterInvocation)object).getRequestUrl();     //拦截的url
		int firstQuestionMarkIndex = url.indexOf("?");
		  if (firstQuestionMarkIndex != -1) {
		            url = url.substring(0, firstQuestionMarkIndex);
		        } 
        Iterator<String>ite = resourceMap.keySet().iterator();   //数据库所有的url
        while (ite.hasNext()) {   //查询有没有        
            String resURL = ite.next();    
            if (urlMatcher.pathMatchesUrl(resURL, url)) {   //进行匹配是不是有这个url
            	
                return resourceMap.get(resURL);   //返回这个url        
                }         
            }   
        return null;      
        }    
    public boolean supports(Class<?>clazz) {   
            return true;    
            }   
    public Collection<ConfigAttribute> getAllConfigAttributes() {   
        return null;    
        }  
    } 