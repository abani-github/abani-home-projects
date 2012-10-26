/**
 * 
 */
package org.servlet.activator;

import java.util.logging.Logger;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

/**
 * @author abani
 *
 */
public class ServletActivator implements BundleActivator {
	private static final Logger LOGGER = Logger.getLogger(ServletActivator.class.getName());
	public void start(BundleContext ctx) throws Exception {
		LOGGER.info("Registering Servlets");
		ServiceReference sRef = ctx.getServiceReference(HttpService.class.getName());
		if ( null != sRef ) {
			HttpService httpService = (HttpService)ctx.getService(sRef);
			httpService.registerServlet("/hallo", new SimpleServlet(), null, null);
			httpService.registerServlet("/osgipost", new PostServlet(), null, null);
		}
		LOGGER.info("Servlets Registered");
	}

	public void stop(BundleContext arg0) throws Exception {
		
	}

}
