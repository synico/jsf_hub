package com.nick.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DataLoadController {

    private Logger log = LoggerFactory.getLogger(DataLoadController.class);

    public void load() {
        log.info("load...");
    }

}
