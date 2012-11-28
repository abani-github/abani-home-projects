/**
 * 
 */
package org.client.activator;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.demo.services.GreetService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * @author abani
 *
 */
public class ClientActivator implements BundleActivator {
	private static final Logger LOGGER = Logger.getLogger( ClientActivator.class.getName() );
	public void start(BundleContext ctx) throws Exception {
		//ServiceReference ser = ctx.getServiceReference(GreetService.class.getName(), "(service=service.v.1)");
		ServiceReference ser = ctx.getServiceReference(GreetService.class.getName());
		GreetService greetService = (GreetService) ctx.getService( ser ) ;
		LOGGER.log(Level.INFO, "Message is :: {0} ", greetService.greetUser("abani"));
	}

	public void stop(BundleContext ctx) throws Exception {
		
	}

}
