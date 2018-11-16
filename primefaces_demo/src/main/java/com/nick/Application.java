package com.nick;

import com.nick.domain.AssetInfo;
import com.nick.repository.AssetInfoRepository;
import com.nick.util.MyDatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
@EnableJpaRepositories
public class Application {

    public static void main(String[] args) {
//        getAnnotation(Application.class);
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    AssetInfoRepository assetInfoRepository;

//    @PostConstruct
    public void init() {
        Iterator<AssetInfo> assetInfos;
        assetInfos = assetInfoRepository.findAll().iterator();
//        while(assetInfos.hasNext()) {
//            System.out.println(assetInfos.next());
//        }

        List<AssetInfo> assetInfoList = assetInfoRepository.findByNameContaining("设备");
        System.out.println("Size: " + assetInfoList.size());

        Pageable pagination = PageRequest.of(2, 10);
        Page<AssetInfo> assetInfoPage = assetInfoRepository.findByNameContaining("设备", pagination);
        System.out.println(assetInfoPage.getTotalElements());
    }

    private static void getAnnotation(Class clz) {
        for(Annotation annotation : clz.getAnnotations()) {
            System.out.println("Annotation: " + annotation);
            getAnnotation(annotation.annotationType());
        }
    }
}
