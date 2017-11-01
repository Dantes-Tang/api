/* Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights
 * reserved.
 * Use is subject to license terms. */

package com.capgemini.drms.web.ldap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.drms.dao.impl.LdapUserDaoImpl;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.service.SkillMatrixService;
import com.capgemini.drms.service.UserPermissionService;
@RequestMapping(value="/api")
public class LdapUserDetailsContextMapper implements UserDetailsContextMapper
{
	
	@Autowired
	private UserPermissionService userPermissionService;
	@Autowired
	private SkillMatrixService skillMatrixService;
	
	private List<String> rolesList;
	public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
            Collection<? extends GrantedAuthority> authorities)
    {
		CapgUser capgUser = new CapgUser();
	
		List<Map<String, String>> existUser=userPermissionService.findUser(username);
		
		List<String> authorityList=userPermissionService.findUserPermission(username);
		
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		LdapUserDaoImpl laLdapUserDaoImpl=new LdapUserDaoImpl();
		if (existUser.isEmpty()) {
			/**
			 * @author : winson luo 
			 * @version ：Jan 23, 2017 5:34:03 PM
			 * chage the param typr to capguser for the extence of the data app_user
			 */
			
			capgUser=laLdapUserDaoImpl.getLDAPUser(username);
			capgUser.setFacePic("upload.png");
			userPermissionService.addCapgUser(capgUser);		
			userPermissionService.addCapgUserRole(userPermissionService.findIDByUserName(capgUser.getUserName()).get(0));
			userPermissionService.findUserInformation(capgUser.getUserName());
			auth.add(new SimpleGrantedAuthority("ROLE_USER"));	
			capgUser.setAuthorities(auth);
			
			rolesList = new ArrayList<String>();
			for (GrantedAuthority grantedAuthority : auth)
            {
                String role = grantedAuthority.getAuthority();
                rolesList.add(role);
            }
			
		}else {
				capgUser=laLdapUserDaoImpl.getLDAPUser(username);
				for(String authority:authorityList){
				auth.add(new SimpleGrantedAuthority(authority));	
				capgUser.setAuthorities(auth);  
			    rolesList = new ArrayList<String>();
	            for (GrantedAuthority grantedAuthority : auth)
	            {
	                String role = grantedAuthority.getAuthority();
	                rolesList.add(role);
	            }
	            
		    }
		}
        return capgUser;
    }
	
	/**
	 * @return 
	 */
	@RequestMapping(value="/control/getRoles" ,method=RequestMethod.POST)
	public  @ResponseBody List<String> getRoles(){
	    for (String string : rolesList)
        {
            System.out.println(string);
        }
	    return rolesList;
	}
    public void mapUserToContext(UserDetails user, DirContextAdapter ctx)
    {
        throw new UnsupportedOperationException(
                "LdapUserDetailsContextMapper only supports reading from a context. Please" +
                        "use a subclass if mapUserToContext() is required.");

    }
}
