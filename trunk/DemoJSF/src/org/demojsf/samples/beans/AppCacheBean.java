/**
 * 
 */
package org.demojsf.samples.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * @author behera
 *
 */
@ManagedBean ( name = "appCache", eager = true )
@ApplicationScoped
public class AppCacheBean {
	private static final Logger LOGGER = Logger.getLogger(AppCacheBean.class.getName());
	public Map<String, String> cache;
	
	public AppCacheBean() {
		LOGGER.log(Level.INFO, "Initializing Bean");
	}
	
	@PostConstruct
	public void initCache () {
		LOGGER.log(Level.INFO, "Initializing cache");
		cache = new HashMap<String, String>();
		cache.put("attr0", "firstname");
		cache.put("attr1", "lastname");
		cache.put("attr2", "email");
	}
	@PreDestroy
	public void destroyCache(){
		LOGGER.log(Level.INFO, "Destroying cache");
		cache.clear();
	}
}
