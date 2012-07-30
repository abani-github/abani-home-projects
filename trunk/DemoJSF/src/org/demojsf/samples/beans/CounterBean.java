/**
 * 
 */
package org.demojsf.samples.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 * @author behera
 *
 */
@ManagedBean( name = "count" )
@SessionScoped
public class CounterBean implements Serializable {
	private static final long serialVersionUID = 6499154494910177344L; 
	
	Integer count = 0; 

    public Integer getCount() {
        return count++;
    }
    
    public void reset(ActionEvent ae) {
        count = 0;
    }
}
