/**
 * 
 */
package org.demojsf.samples.beans;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * @author behera
 *
 */
@ManagedBean ( name = "langBean", eager = true )
@ApplicationScoped
public class LanguageBean {
	private Map<String, Locale> langMap ;
	private FacesContext ctx = FacesContext.getCurrentInstance();
	public LanguageBean() {
		langMap = new HashMap<String, Locale>();
		langMap.put("en", Locale.ENGLISH);
		langMap.put("de", Locale.GERMAN);
		langMap.put("es", Locale.FRANCE);
	}
	
	public String setLocale(){
		ctx.getViewRoot().setLocale(Locale.GERMAN);
		return "index";
	}
}
