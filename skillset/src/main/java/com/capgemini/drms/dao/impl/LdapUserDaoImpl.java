/* Copyright 2011 CAPGEMINI Financial Service GBU, Inc. All rights
 * reserved.
 * Use is subject to license terms. */

package com.capgemini.drms.dao.impl;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import com.capgemini.drms.dao.LdapUserDao;
import com.capgemini.drms.model.CapgUser;
import com.capgemini.drms.util.DateUtil;

// TODO Add class/interface import here and remove this line.

/**
 * TODO Add class/interface description here and remove this line.
 * 
 * @author calvye, create on 22 Mar 2013 Revision History: TODO Revised by XXXX
 *         on 201x/xx/xx, modified xxx
 */

public class LdapUserDaoImpl implements LdapUserDao {
	private LdapTemplate ldapTemplate;

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public CapgUser loadCapgUserFromLdap(String userName) {

		// String filter_string = "(&(objectClass=user)(cn=jzhang))";
		AndFilter filter = new AndFilter();
		filter.and(new EqualsFilter("objectclass", "user"));
		filter.and(new EqualsFilter("cn", userName));
		List list = ldapTemplate.search("", filter.encode(),
				new ChraUserAttributesMapper());
		if (list != null && list.size() > 0) {
			return (CapgUser) list.get(0);
		}
		return null;
	}

	private class ChraUserAttributesMapper implements AttributesMapper {
		public Object mapFromAttributes(Attributes attrs)
				throws NamingException {
			CapgUser user = new CapgUser();
			user.setDomain("CORP");

			user.setUserName((String) attrs.get("cn").get());
			String userPrincipalName = (String) attrs.get("userPrincipalName")
					.get();
			String temp = userPrincipalName.substring(0,
					userPrincipalName.indexOf("@"));

			String[] strs = temp.split("\\.");

			String firstName = strs[0];
			String lastName = strs[1];

			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail((String) attrs.get("mail").get());
			//user.setJoinDate(DateUtil.formatUserFromLDAP((String) attrs.get(
			//		"capgemini-StartDate").get()));
			user.setEmployeeId((String) attrs.get("employeeNumber").get());

			return user;
		}
	}

	public List getAllPersonNames() {
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:389/dc=example,dc=com");
		DirContext ctx;
		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
		LinkedList list = new LinkedList();
		NamingEnumeration results = null;

		try {
			SearchControls controls = new SearchControls();
			controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			results = ctx.search("", "(objectclass=person)", controls);
			while (results.hasMore()) {
				SearchResult searchResult = (SearchResult) results.next();
				Attributes attributes = searchResult.getAttributes();
				Attribute attr = attributes.get("cn");
				String cn = (String) attr.get();
				list.add(cn);
			}
		} catch (NameNotFoundException e) {
			// The base context was not found.
			// Just clean up and exit.
		} catch (NamingException e) {
			throw new RuntimeException(e);
		} finally {
			if (results != null) {
				try {
					results.close();
				} catch (Exception e) {
					// Never mind this.
				}
			}
			if (ctx != null) {
				try {
					ctx.close();
				} catch (Exception e) {
					// Never mind this.
				}
			}
		}
		return list;
	}

	/**
	 * 
	 * @author : winson luo
	 * @version ：Jan 23, 2017 5:34:03 PM
	 * @Title: getLDAPUser
	 * @Description: get User info from LDAP
	 * @param @param userName
	 * @param @return
	 * @return CapgUser
	 * @throws
	 */
	public CapgUser getLDAPUser(String userName) {
		CapgUser capgUser = new CapgUser();
		capgUser.setUserName(userName);
		String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";

		String MY_HOST = "ldap://wadcnhgh02.corp.capgemini.com/";
		String MY_SEARCHBASE = "dc=corp,dc=capgemini,dc=com";
		// String MY_FILTER = "(cn="+userName+")";
		AndFilter MY_FILTER = new AndFilter();
		MY_FILTER.and(new EqualsFilter("cn", userName));
		// MY_FILTER.and(new EqualsFilter("ou", "Employees"));
		// MY_FILTER.and(new EqualsFilter("mail", "mail"));

		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITCTX);
		env.put(Context.PROVIDER_URL, MY_HOST);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException e) {

			e.printStackTrace();

		}

		if (ctx == null) {

			return null;
		}

		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "mail" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String PreEmail = sr.getAttributes().get("mail").toString();
					StringBuffer stringBuffer = new StringBuffer(PreEmail);
					String email = stringBuffer
							.substring(stringBuffer.indexOf(":") + 1)
							.toString().trim();
					String temp = stringBuffer.substring(
							stringBuffer.indexOf(":") + 1,
							stringBuffer.indexOf("@")).trim();
					String[] strs = temp.split("\\.");
					String firstName = strs[0];
					firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
					String lastName = strs[1];
					lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
					String fullName = firstName + " " + lastName;
					capgUser.setFirstName(firstName);
					capgUser.setLastName(lastName);
					capgUser.setFullName(fullName);
					capgUser.setEmail(email);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();

		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "employeeNumber" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String temp = sr.getAttributes().get("employeeNumber")
							.toString();
					StringBuffer tempNumber = new StringBuffer(temp);
					String employeeNumber = tempNumber
							.substring(tempNumber.indexOf(":") + 1).toString()
							.trim();

					capgUser.setEmployeeId(employeeNumber);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();

		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "telephonenumber" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String temp = sr.getAttributes().get("telephonenumber")
							.toString();
					StringBuffer tempNumber = new StringBuffer(temp);
					String phone = tempNumber
							.substring(tempNumber.indexOf(":") + 1).toString()
							.trim();

					capgUser.setPhone(phone);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();

		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "capgemini-StartDate" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String temp = sr.getAttributes().get("capgemini-StartDate")
							.toString();
					StringBuffer tempDate = new StringBuffer(temp);
					String joinDate = tempDate.substring(temp.indexOf(":") + 1)
							.toString().trim();
					capgUser.setJoinDate(joinDate);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "manager" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String temp = sr.getAttributes().get("manager")
							.toString();
					StringBuffer tempDate = new StringBuffer(temp);
					String maneger = tempDate.substring(temp.indexOf("=")+1,temp.indexOf(","))
							.toString().trim();
					capgUser.setManager(maneger);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		return capgUser;
	}
	
	/**
	 * 
	 * @author : honghui wu
	 * @version ：March 13, 2017 11:05:01 AM
	 * @Title: findLdapUserByEmail
	 * @Description: get User info from LDAP by user's email
	 * @param: Email
	 * @return: CapgUser
	 * @throws
	 */
	public CapgUser findLdapUserByEmail(String Email){
		CapgUser capgUser = new CapgUser();
		capgUser.setEmail(Email);
		String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";

		String MY_HOST = "ldap://wadcnhgh02.corp.capgemini.com/";
		String MY_SEARCHBASE = "dc=corp,dc=capgemini,dc=com";
		// String MY_FILTER = "(cn="+userName+")";
		AndFilter MY_FILTER = new AndFilter();
		MY_FILTER.and(new EqualsFilter("userprincipalname", Email));
		// MY_FILTER.and(new EqualsFilter("ou", "Employees"));
		// MY_FILTER.and(new EqualsFilter("mail", "mail"));

		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITCTX);
		env.put(Context.PROVIDER_URL, MY_HOST);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
		} catch (NamingException e) {

			e.printStackTrace();

		}

		if (ctx == null) {

			return null;
		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "mail" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String PreEmail = sr.getAttributes().get("mail").toString();
					StringBuffer stringBuffer = new StringBuffer(PreEmail);
					String email = stringBuffer
							.substring(stringBuffer.indexOf(":") + 1)
							.toString().trim();
					String temp = stringBuffer.substring(
							stringBuffer.indexOf(":") + 1,
							stringBuffer.indexOf("@")).trim();
					String[] strs = temp.split("\\.");
					System.out.println(strs);
					String firstName = strs[0];
					System.out.println(firstName);
					firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
					System.out.println(firstName);
					String lastName = strs[1];
					System.out.println(lastName);
					lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
					System.out.println(lastName);
					String fullName = firstName + " " + lastName;
					capgUser.setFirstName(firstName);
					capgUser.setLastName(lastName);
					capgUser.setFullName(fullName);
					capgUser.setEmail(email);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();

		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "employeeNumber" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String temp = sr.getAttributes().get("employeeNumber")
							.toString();
					StringBuffer tempNumber = new StringBuffer(temp);
					String employeeNumber = tempNumber
							.substring(tempNumber.indexOf(":") + 1).toString()
							.trim();

					capgUser.setEmployeeId(employeeNumber);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();

		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "telephonenumber" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String temp = sr.getAttributes().get("telephonenumber")
							.toString();
					StringBuffer tempNumber = new StringBuffer(temp);
					String phone = tempNumber
							.substring(tempNumber.indexOf(":") + 1).toString()
							.trim();

					capgUser.setPhone(phone);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();

		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "capgemini-StartDate" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				System.out.println(obj);
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					System.out.println(sr);
					String temp = sr.getAttributes().get("capgemini-StartDate")
							.toString();
					StringBuffer tempDate = new StringBuffer(temp);
					System.out.println(temp);
					System.out.println(tempDate);
					String joinDate = tempDate.substring(temp.indexOf(":") + 1)
							.toString().trim();
					System.out.println(joinDate);
					capgUser.setJoinDate(joinDate);
					System.out.println(joinDate);
				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "manager" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				System.out.println(obj);
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					System.out.println(sr);
					String temp = sr.getAttributes().get("manager")
							.toString();
					System.out.println(temp);
					StringBuffer tempDate = new StringBuffer(temp);
					String maneger = tempDate.substring(temp.indexOf("=")+1,temp.indexOf(","))
							.toString().trim();
					capgUser.setManager(maneger);
					System.out.println(maneger);
				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		try {
			SearchControls constrains = new SearchControls();
			String returnedAtts[] = { "mailnickname" }; // 定制返回属性
			constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				System.out.println(obj);
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					System.out.println(sr);
					String temp = sr.getAttributes().get("mailnickname")
							.toString();
					System.out.println(temp);
				    String userName = temp.substring(temp.indexOf(":")+1).toString().trim();
				    System.out.println(userName);
				    capgUser.setUserName(userName);
					
				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		return capgUser;
	}
}
