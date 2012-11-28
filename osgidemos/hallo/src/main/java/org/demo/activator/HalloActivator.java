/**
 * 
 */
package org.demo.activator;

import java.util.Hashtable;
import java.util.logging.Logger;

import org.demo.services.GreetService;
import org.demo.services.GreetServiceImpl;
import org.demo.services.GreetServiceImplExt;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author abani
 *
 */
public class HalloActivator implements BundleActivator {
	private static final Logger LOGGER = Logger.getLogger( HalloActivator.class.getName() );
	public void start(BundleContext ctx) throws Exception {
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("service", "service.v.1");
		LOGGER.info("staring bundle HalloActivator");
		LOGGER.info("Registering Service GreetService");
		
		ctx.registerService(GreetService.class.getName(), new GreetServiceImpl(), props);
		
		props.clear();
		props.put("service", "service.v.2");
		ctx.registerService(GreetService.class.getName(), new GreetServiceImplExt(), props);
	}

	public void stop(BundleContext ctx) throws Exception {
		LOGGER.info("stoping bundle HalloActivator");
	}

}
