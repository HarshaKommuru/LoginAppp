package com.caps.model.service;

public class Validation {
	
	public static boolean isCharacter(String str) 
    { 
        if((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$"))) 
        	return true;
        else 
    	return false;
    	
    }
	public static  boolean password(String pass) {
		String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}~";
		String str2[]=pass.split("");

	if(pass.length()==0) 
		return false;
	else
	{
		for (int i=0;i<str2.length;i++)
		{
			if (true==specialCharacters.contains(str2[i]))
			return true;
		}return false;
	}
	}
public static	boolean login(String usernm,String pass) {
	boolean uname=isCharacter(usernm);
	boolean passwd=password(pass);
	if(uname&passwd)
		return true;
	else
		return false;
		
	}
		
	
}