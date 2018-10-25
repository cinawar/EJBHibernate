package com.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;


@Stateful
public class DenemeSessionBean implements TesterInterfaces {

    //Urun tipnde bir tane listemiz var
    private List<ejbPojo> ejbs;

    public DenemeSessionBean() {
    	ejbs = new ArrayList<ejbPojo>();
    }
 
  
    public List<ejbPojo> getDeneme() {
		 return ejbs;
	}
	public void setDeneme(ejbPojo deneme1) {
		ejbs.add(deneme1);
		
	}
}