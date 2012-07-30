/**
 * 
 */
package org.demojsf.samples.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * @author behera
 *
 */
@ManagedBean ( name = "ajaxBean" )
@ViewScoped
public class AjaxBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1136049189808164811L;
	private String user;
	private String result;
	private String selection;
	
	public AjaxBean() {
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * @return the selection
	 */
	public String getSelection() {
		return selection;
	}

	/**
	 * @param selection the selection to set
	 */
	public void setSelection(String selection) {
		this.selection = selection;
	}

	public void handleAjaxEvent ( AjaxBehaviorEvent event ) {
		if ( "ajaxForm:user".equalsIgnoreCase(event.getComponent().getClientId()) ) {
			setResult("Hi " + user + " welcome to JSF/Ajax");
		}else {
			setResult("You have selected :: " + selection);
		}
		
	}
}
