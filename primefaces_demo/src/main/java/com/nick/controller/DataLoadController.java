package com.nick.controller;

import com.nick.domain.AssetInfo;
import com.nick.domain.Attribute;
import com.nick.domain.SharedAssetReqDetail;
import com.nick.repository.AssetInfoRepository;
import com.nick.repository.AttributeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Set;

@ManagedBean
public class DataLoadController {

    private Log log = LogFactory.getLog(DataLoadController.class);

    private AssetInfoRepository assetInfoRepository;

    private AttributeRepository attributeRepository;

    private void init() {
        ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        assetInfoRepository = (AssetInfoRepository) ctx.getBean("assetInfoRepository");
        attributeRepository = (AttributeRepository) ctx.getBean("attributeRepository");
    }

    public void load() {
        log.info("load...");
        init();
        List<AssetInfo> assets = assetInfoRepository.findByName("资产18080202");
        log.info("size: " + assets.size());
        for(AssetInfo ai : assets) {
            Set<SharedAssetReqDetail> reqDetails = ai.getSharedAssetReqDetailSet();
            if(reqDetails == null) {
                System.out.println(ai);
            }
        }
//        Iterator<AssetInfo> iter = assetInfoRepository.findAll().iterator();
//        while(iter.hasNext()) {
//            AssetInfo info = iter.next();
//            log.info(info);
//        }
//        createAttr();
        loadAttributesByDesc();
    }

    public void createAttr() {
//        Attribute attr = new Attribute("牙医配件", "nick", "nick");
//        Set<AttrDesc> descSet = new HashSet<AttrDesc>();
//        AttrDesc desc1 = new AttrDesc(attr.getAttributeUid(), "属性1", true);
//        AttrDesc desc2 = new AttrDesc(attr.getAttributeUid(), "属性2", false);
//        descSet.add(desc1);
//        descSet.add(desc2);
//        attr.setAttrDescSet(descSet);
//        attributeRepository.save(attr);
    }

    public void loadAttributeList() {
        List<Attribute> list = attributeRepository.findAll();
//        list.stream().map(item -> item.getAttributeUid()).forEach(System.out::println);
    }

    public void loadAttributesByDesc() {
        List<Attribute> attributes = attributeRepository.findByAttrDesc("1");
        attributes.stream().forEach(System.out::println);
        log.info("size of attribute: " + attributes.size());
    }
}
