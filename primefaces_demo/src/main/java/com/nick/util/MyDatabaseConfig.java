package com.nick.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
            transactionManagerRef = "transactionManager")
public class MyDatabaseConfig {

    @Bean(name = "transactionManager")
    public PlatformTransactionManager myTransactionManager() {
        return new JpaTransactionManager(this.myEntityManagerFactory().getObject());
    }

    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean myEntityManagerFactory() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(this.myDataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        factoryBean.setPackagesToScan("com.nick.domain", "com.nick.repositories");

        return factoryBean;
    }

    @Bean
    public DataSource myDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDefaultAutoCommit(true);
        ds.setInitialSize(1);
        ds.setMaxTotal(20);
        ds.setMaxIdle(1);
        ds.setMaxWaitMillis(10000);
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:54322/ge_apm");
        ds.setUsername("postgres");
        ds.setPassword("root");
        return ds;
    }

}
