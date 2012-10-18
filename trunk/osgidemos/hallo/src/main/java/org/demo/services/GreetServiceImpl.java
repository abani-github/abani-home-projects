/**
 * 
 */
package org.demo.services;

/**
 * @author abani
 *
 */
public class GreetServiceImpl implements GreetService {

	/* (non-Javadoc)
	 * @see org.demo.services.GreetService#greetUser(java.lang.String)
	 */
	public String greetUser(String user) {
		return "Hallo " + user + "..Wecome to OSGi";
	}

}
