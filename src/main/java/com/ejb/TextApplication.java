package com.ejb;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TextApplication {

	public static void main(String[] args) throws NamingException {
		TesterBean test = new TesterBean();
		ejbPojo ejb=new ejbPojo();
		ejb.setAciklama("aciklama");
		test.setEjbPojo(ejb);
		
		System.out.println("lisy of");
		System.out.println(test.getTable());
	}

}
