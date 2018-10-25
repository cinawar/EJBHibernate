package com.ejb;

import javax.ejb.*;

@Stateless
public class HelloEJB {

    private String name;
    public String hello() {
        return "Hello , " + this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}