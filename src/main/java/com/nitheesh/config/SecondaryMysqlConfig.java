package com.nitheesh.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = BeanConstant.SECONDARY_REPOSITORY_PREFIX,
        entityManagerFactoryRef = BeanConstant.SECONDARY_ENTITY_MANAGER_FACTORY_BEAN,
        transactionManagerRef = BeanConstant.SECONDARY_PLATFORM_TRANSACTION_MANAGER)
public class SecondaryMysqlConfig {

    @Bean(name = BeanConstant.SECONDARY_DATA_SOURCE)
    @ConfigurationProperties(prefix = BeanConstant.SECONDARY_YML_PREFIX)
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = BeanConstant.SECONDARY_ENTITY_MANAGER_FACTORY_BEAN)
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier(BeanConstant.SECONDARY_DATA_SOURCE) DataSource dataSource) {
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages(BeanConstant.SECONDARY_DOMAIN_PREFIX)
                .persistenceUnit(BeanConstant.SECONDARY_PERSISTENCE_UNIT)
                .build();
    }


    @Bean(name = BeanConstant.SECONDARY_PLATFORM_TRANSACTION_MANAGER)
    public PlatformTransactionManager primaryPlatformTransactionManager(
            @Qualifier(BeanConstant.SECONDARY_ENTITY_MANAGER_FACTORY_BEAN) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


    @Bean(name = BeanConstant.SECONDARY_JDBC_TEMPLATE)
    public JdbcTemplate primaryJdbcTemplate(@Qualifier(BeanConstant.SECONDARY_DATA_SOURCE) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
