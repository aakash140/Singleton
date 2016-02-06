package com.java.singleton;

import java.io.Serializable;

public class EmployeeSingleton implements Serializable {

	private static final long serialVersionUID=42L;
	private static EmployeeSingleton instance;
	
	private int field=50;
	
	public int getField(){
		return field;
	}
	
	public void setField(int field){
		this.field=field;
	}
	public static EmployeeSingleton getInstance(){
		if(instance==null)
			instance=new EmployeeSingleton();
		return instance;
	}
	protected Object readResolve(){
		return instance;
	}
}