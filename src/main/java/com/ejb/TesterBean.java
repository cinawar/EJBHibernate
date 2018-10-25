package com.ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean(name = "TesterBeans")
@SessionScoped
public class TesterBean {

    // En basta EJB’ lere interfaceler aracılığı ile ulaşılır demistik bunun icin
    // @EJB notasyonu ile interface sinifimizdan referans
    // aliyoruz ki methodlarimizi kullanabilelim
    @EJB
    TesterInterfaces bean;
    ejbPojo ejbPojo;

    public TesterBean() {
        ejbPojo = new ejbPojo();
    }

    // Birtane urun nesnemizi alip listimize ekleyen
    // ejb methodumuza gonderiyoruz
    // ve sayfamizi refresh yapiyoruz
    public String setTable() {
        bean.setDeneme(ejbPojo);
        return "index.xhtml";
    }

    //Burada ise jsf sayfamizdaki tabloya listemizdeki urunleri yazdiracayiz
    public List<ejbPojo> getTable() {
        return bean.getDeneme();
    }

    public ejbPojo getEjbPojo() {
        return ejbPojo;
    }

    public void setEjbPojo(ejbPojo ejbPojo) {
        this.ejbPojo = ejbPojo;
    }
}