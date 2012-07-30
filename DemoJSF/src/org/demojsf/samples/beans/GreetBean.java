/**
 * 
 */
package org.demojsf.samples.beans;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * @author behera
 *
 */
@ManagedBean ( name = "greet" )
@RequestScoped
public class GreetBean {
	
	private String tagretAction;
	private String message;
	
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	private FacesContext ctx = FacesContext.getCurrentInstance();
	
	public String getTagretAction() {
		return tagretAction;
	}

	public void setTagretAction(String tagretAction) {
		this.tagretAction = tagretAction;
	}

	public GreetBean() {
	}
	
	public String greet () {
		return "Wel Come to JSF 2";
	}
	
	public void handleAjaxEvent(AjaxBehaviorEvent event) {
		System.out.println("GreetBean.handleAjaxEvent()");
		this.setMessage("Hallo Welcome come to JSF2 ajax ");
	}
	
	public String invokeAction () {
		//Locale.setDefault(newLocale) locale = ctx.getViewRoot().getLocale();
		//Locale.setDefault(Locale.GERMAN);
		ctx.getViewRoot().setLocale(Locale.CANADA);
		System.out.println("GreetBean.invokeAction() tagretAction " + tagretAction );
		return "welcome";
	}
}
