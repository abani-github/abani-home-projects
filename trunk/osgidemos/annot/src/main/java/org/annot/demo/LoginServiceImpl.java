/**
 * 
 */
package org.annot.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

/**
 * @author behera
 *
 */
@Component( immediate = true, metatype = true, description = "LoginService Component" )
@Service ( value = LoginService.class )
public class LoginServiceImpl implements LoginService {
	private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class.getName());
	/* (non-Javadoc)
	 * @see org.annot.demo.LoginService#login(java.lang.String)
	 */
	public boolean login(String user) {
		LOGGER.log(Level.INFO, "invoking login for {0} ", user );
		return user == null ? false : true;
	}

}
