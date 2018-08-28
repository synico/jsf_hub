package com.nick.controller;

import com.nick.domain.AssetInfo;
import com.nick.domain.Attribute;
import com.nick.domain.SharedAssetReqDetail;
import com.nick.domain.chapter5.Address;
import com.nick.domain.chapter5.User;
import com.nick.repository.AssetInfoRepository;
import com.nick.repository.AttributeRepository;
import com.nick.repository.UserRepository;
import com.nick.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ManagedBean
//@EnableJpaAuditing
public class DataLoadController {

    private Log log = LogFactory.getLog(DataLoadController.class);

    private AssetInfoRepository assetInfoRepository;

    private AttributeRepository attributeRepository;

    private UserRepository userRepository;

    private UserService userService;

    private Specification<AssetInfo> specification = new Specification<AssetInfo>() {
        @Override
        public Predicate toPredicate(Root<AssetInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            List<Predicate> list = new ArrayList<>();
//            Join<AssetInfo, SharedAssetType> join = root.join();
            Predicate[] p = new Predicate[list.size()];
            return cb.and(list.toArray(p));
        }
    };

    private void init() {
        ApplicationContext ctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
        assetInfoRepository = (AssetInfoRepository) ctx.getBean("assetInfoRepository");
        attributeRepository = (AttributeRepository) ctx.getBean("attributeRepository");
        userRepository = (UserRepository) ctx.getBean("userRepository");
//        userService = (UserService) ctx.getBean("userService");
    }

    public void load() {
        log.info("load...");
        init();
        loadAssets();
//        createAttr();
//        loadAttributes();
//        loadAttributesByDesc();
//        saveUser();
    }

    public void loadAssets() {
        List<AssetInfo> assets = assetInfoRepository.findByName("资产18080202");
        log.info("size: " + assets.size());
        for(AssetInfo ai : assets) {
            Set<SharedAssetReqDetail> reqDetails = ai.getSharedAssetReqDetailSet();
            if(reqDetails == null) {
                System.out.println(ai);
            }
        }
        List<AssetInfo> list = assetInfoRepository.findBySwapName("4111");
        for(AssetInfo ai : list) {
            log.info(ai.toString());
        }
    }

    public void createAttr() {
        Attribute attr = new Attribute();
        attr.setName("牙医附件");
        attr.setTenantUid("0");
        attr.setInstitutionUid("0");
        attr.setHospitalUid("0");
        attr.setSiteUid("0");
        attr.setCreatedBy("nick");
        attr.setCreatedDate(new Date());
        attr.setLastModifiedBy("nick");
        attr.setLastModifiedDate(new Date());
        attributeRepository.save(attr);
    }

    public void loadAttributes() {
        List<Attribute> attrList = attributeRepository.findByNameContaining("属性");
        for(Attribute attr : attrList) {
            log.info("Attribute: name: " + attr.getName() + ", lenOfName: " + attr.getNameLen());
            attr.setDescription(attr.getDescription() + "1");
            attributeRepository.save(attr);
            log.info("lastUpdatedDate: " + attr.getLastModifiedDate());
            log.info("------------------------------------------");
        }
    }

    public void loadAttributeList() {
        List<Attribute> list = attributeRepository.findAll();
//        list.stream().map(item -> item.getAttributeUid()).forEach(System.out::println);
    }

    public void loadAttributesByDesc() {
        List<Attribute> attributes = attributeRepository.findByAttrDesc("1");
        attributes.stream().map(item -> item.getName()).forEach(System.out::println);
        log.info("size of attribute: " + attributes.size());
    }

    public void saveUser() {
        User a = new User();
        a.setFirstName("Nick");
        a.setLastName("Liu");

        Address addr = new Address("st", "85034", "sh");
        a.setHomeAddress(addr);

        userRepository.save(a);
    }
}
