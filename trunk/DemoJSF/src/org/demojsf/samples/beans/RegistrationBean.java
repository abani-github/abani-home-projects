/**
 * 
 */
package org.demojsf.samples.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.demojsf.samples.entities.Employee;

/**
 * @author behera
 *
 */
@ManagedBean ( name = "reg" )
@RequestScoped
public class RegistrationBean {
	
	private Employee employee;
	
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public RegistrationBean() {
		employee = new Employee();
	}
	
	public String register(){
		System.out.println("Employee " + employee);
		return "reg";
	}
}
