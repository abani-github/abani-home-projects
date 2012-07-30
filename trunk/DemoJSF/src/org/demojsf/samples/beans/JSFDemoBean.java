/**
 * 
 */
package org.demojsf.samples.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * @author behera
 *
 */
@RequestScoped
@ManagedBean ( name = "jsfDemo" )
public class JSFDemoBean {
	@ManagedProperty (value = "#{param['id']}" )
	private String queryParam;

	@ManagedProperty ( value ="#{appCache}" )
	private AppCacheBean appCacheBean;
	
	public void setAppCacheBean(AppCacheBean appCacheBean) {
		this.appCacheBean = appCacheBean;
	}

	public String getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(String queryParam) {
		this.queryParam = queryParam;
	}
	
	public String print () {
		System.out.println("JSFDemoBean.print() appCache " + appCacheBean.cache);
		return "Query Param is :: " + this.queryParam;
	}
	
}
