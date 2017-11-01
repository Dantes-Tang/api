import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;

import com.capgemini.drms.model.CapgUser;

public class Temptset {
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
			//String returnedAtts[] = { "manager" }; // 定制返回属性
			//constrains.setReturningAttributes(returnedAtts);
			constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
			NamingEnumeration results = ctx.search(MY_SEARCHBASE,
					MY_FILTER.encode(), constrains);

			while (results.hasMoreElements()) {
				Object obj = results.next();
				System.out.println(obj);
				if (obj instanceof SearchResult) {
					SearchResult sr = (SearchResult) obj;
					String temp = sr.getAttributes().get("manager")
							.toString();
					System.out.println("temp "+temp );
					StringBuffer tempDate = new StringBuffer(temp);
					System.out.println(temp.indexOf(","));

					String maneger = tempDate.substring(temp.indexOf("=")+1,temp.indexOf(","))
							.toString().trim();
					System.out.println(maneger);
					capgUser.setManager(maneger);

				}
			}

		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		return capgUser;
	}
	
	
	public static void main(String[] args){
		Temptset temptset=new Temptset();
		temptset.getLDAPUser("winluo");
	}
}
