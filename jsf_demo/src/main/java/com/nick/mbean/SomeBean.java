package com.nick.mbean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="someBean")
public class SomeBean {

    public SomeBean() {
        System.err.println("constructor of SomeBean......");
    }
    
    private String someProperties = "Blah, blah";
    
    public String getSomeProperty() {
        return someProperties;
    }
    
    public void setSomeProperty(String sp) {
        this.someProperties = sp;
    }
    
    public String someActionControllerMethod() {
        return "accordion_panel";
    }
    
    public String someOtherActionControllerMethod() {
        return "index";
    }

}
