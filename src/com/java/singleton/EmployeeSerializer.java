package com.java.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class EmployeeSerializer {

	private static EmployeeSingleton instance1=EmployeeSingleton.getInstance();
	public static void main(String[] args){
		PrintWriter pw=null; 
		try{
			pw=new PrintWriter(new File("src/SerializationError.log"));
			ObjectOutput out=new ObjectOutputStream(new FileOutputStream(new File("src/empSer.ser")));
			out.writeObject(instance1);
			out.close();
			
			instance1.setField(10);
			
			ObjectInput in=new ObjectInputStream(new FileInputStream(new File("src/empSer.ser")));
			EmployeeSingleton instance2=(EmployeeSingleton)in.readObject();
			System.out.println(instance1.getField());
			System.out.println(instance2.getField());
			in.close();
	
		}
		catch(IOException |ClassNotFoundException exception){
			exception.printStackTrace(pw);
		}
	}
}