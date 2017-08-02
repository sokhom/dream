/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model;

import java.util.Date;

public class Employee extends DefaultModel {
	
	private static final long serialVersionUID = 1L;

	private String gender;
	private Date dob;
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	

}
