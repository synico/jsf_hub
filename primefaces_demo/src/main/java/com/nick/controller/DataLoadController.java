package com.nick.controller;

import com.nick.domain.AssetInfo;
import com.nick.repository.AssetInfoRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Iterator;
import java.util.List;

@ManagedBean
public class DataLoadController {

    private Log log = LogFactory.getLog(DataLoadController.class);

    @Autowired
    private AssetInfoRepository assetInfoRepository;

    public void load() {
        log.info("load...");
        ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());

        assetInfoRepository = (AssetInfoRepository) ctx.getBean("assetInfoRepository");
        List<AssetInfo> assets = assetInfoRepository.findByName("资产18080202");
        log.info("size: " + assets);
//        Iterator<AssetInfo> iter = assetInfoRepository.findAll().iterator();
//        while(iter.hasNext()) {
//            AssetInfo info = iter.next();
//            log.info(info);
//        }
    }
}
