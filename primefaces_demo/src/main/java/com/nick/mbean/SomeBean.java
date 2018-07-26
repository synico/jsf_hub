package com.nick.mbean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SomeBean {
    
    private String someProperties = "Blah, blah";

    private int reqQty;
    
    public String getSomeProperty() {
        return someProperties;
    }
    
    public void setSomeProperty(String sp) {
        this.someProperties = sp;
    }

    public int getReqQty() {
        return reqQty;
    }

    public void setReqQty(int reqQty) {
        this.reqQty = reqQty;
    }

    public String someActionControllerMethod() {
        return "accordion_panel";
    }
    
    public String someOtherActionControllerMethod() {
        return "index";
    }

}
