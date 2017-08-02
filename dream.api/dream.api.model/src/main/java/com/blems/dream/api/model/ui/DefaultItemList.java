/***
 * @author ngounphanny
 * 
 */
package com.blems.dream.api.model.ui;

public class DefaultItemList {
	
	private int id;
	private String name;
	private String code;
	
	public DefaultItemList(int id, String name, String code) {
		setId(id);
		setName(name);
		setCode(code);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	

}
