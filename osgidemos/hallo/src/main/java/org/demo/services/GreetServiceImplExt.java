/**
 * 
 */
package org.demo.services;

/**
 * @author behera
 *
 */
public class GreetServiceImplExt implements GreetService {

	/* (non-Javadoc)
	 * @see org.demo.services.GreetService#greetUser(java.lang.String)
	 */
	public String greetUser(String user) {
		return "Hallo " + user;
	}

}
