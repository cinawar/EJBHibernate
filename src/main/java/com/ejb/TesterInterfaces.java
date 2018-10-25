package com.ejb;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface TesterInterfaces {

    // interface clasimizda iki tane methodumuz var

    // Bu methodumuz  bize urunlerimizin oldugu List donderiyor
    public List<ejbPojo> getDeneme();

    //Bu methodumuz ise bizden bir tane urun nesnesi aliyor
    public void setDeneme(ejbPojo deneme1);
 
}