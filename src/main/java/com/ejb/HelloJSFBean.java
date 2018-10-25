package com.ejb;

import com.model.User;

import javax.annotation.Resource;
import javax.faces.bean.*;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


@ManagedBean(name="HelloJSFBean")
//@RequestScoped
@SessionScoped
public  class HelloJSFBean implements java.io.Serializable {
    @EJB
    private HelloEJB helloEJB;

@PersistenceContext(unitName = "HBMFactory")
     private EntityManager entityManager;

    @Resource
    UserTransaction tx;

    public String getMessage() {
        return helloEJB.hello();
    }
    public void setName(String name) throws SystemException {
        helloEJB.setName(name);


        try {

            tx.begin();

            User usr = new User();
            usr.setUserName(name);
            entityManager.persist(usr);

            tx.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (entityManager != null) {
                tx.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {

        }


    }
    public String getName(){
        return helloEJB.getName();
    }
}