package com.nitheesh.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = BeanConstant.PRIMARY_REPOSITORY_PREFIX,
        entityManagerFactoryRef = BeanConstant.PRIMARY_ENTITY_MANAGER_FACTORY_BEAN,
        transactionManagerRef = BeanConstant.PRIMARY_PLATFORM_TRANSACTION_MANAGER)
public class PrimaryMysqlConfig {


    @Bean(name = BeanConstant.PRIMARY_DATA_SOURCE)
    @Primary
    @ConfigurationProperties(prefix = BeanConstant.PRIMARY_YML_PREFIX)
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = BeanConstant.PRIMARY_ENTITY_MANAGER_FACTORY_BEAN)
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactoryBean(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
            @Qualifier(BeanConstant.PRIMARY_DATA_SOURCE) DataSource dataSource) {

        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages(BeanConstant.PRIMARY_DOMAIN_PREFIX)
                .persistenceUnit(BeanConstant.PRIMARY_PERSISTENCE_UNIT)
                .build();
    }


    @Bean(name = BeanConstant.PRIMARY_PLATFORM_TRANSACTION_MANAGER)
    @Primary
    public PlatformTransactionManager primaryPlatformTransactionManager(
            @Qualifier(BeanConstant.PRIMARY_ENTITY_MANAGER_FACTORY_BEAN) EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }


    @Bean(name = BeanConstant.PRIMARY_JDBC_TEMPLATE)
    public JdbcTemplate primaryJdbcTemplate(@Qualifier(BeanConstant.PRIMARY_DATA_SOURCE) DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
