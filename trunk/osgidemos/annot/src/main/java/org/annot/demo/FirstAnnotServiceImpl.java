/**
 * 
 */
package org.annot.demo;

import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;

/**
 * @author behera
 *
 */
@Component( immediate = true, metatype = true, description = "FirstAnnotService Component" )
@Service ( value = FirstAnnotService.class )
@Properties ({
		@Property(name = "audience", value = "WCMS Team")
})
public class FirstAnnotServiceImpl implements FirstAnnotService {
	private static final Logger LOGGER = Logger.getLogger(FirstAnnotServiceImpl.class.getName());
	@Reference
	private LoginService loginService;
	
	@Activate
	public void activateService ( ComponentContext ctx ) {
		@SuppressWarnings("unchecked")
		Dictionary<String, String> props = ctx.getProperties();
		String propValue = props.get("audience");
		LOGGER.log(Level.INFO, "Configuration property value is {0}", propValue );
		LOGGER.info("FirstAnnotService.activateService() activating");
		LOGGER.log(Level.INFO, "Invoke result is {0}", loginService.login("Adobe") );
	}

	public String demoCall() {
		return "You have invoked an SCR service";
	}
}
