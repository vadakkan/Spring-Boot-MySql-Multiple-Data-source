package com.nitheesh.config;

public class BeanConstant {

    public static final String PRIMARY_YML_PREFIX = "database.primary.datasource";
    public static final String PRIMARY_PERSISTENCE_UNIT= "database.primary";
    public static final String PRIMARY_REPOSITORY_PREFIX = "com.nitheesh.mvc.primary.repository";
    public static final String PRIMARY_DOMAIN_PREFIX = "com.nitheesh.mvc.primary.domain";

    public static final String PRIMARY_DATA_SOURCE = "primaryDataSource";
    public static final String PRIMARY_ENTITY_MANAGER_FACTORY_BEAN= "primaryEntityManagerFactoryBean";
    public static final String PRIMARY_PLATFORM_TRANSACTION_MANAGER= "primaryPlatformTransactionManager";
    public static final String PRIMARY_JDBC_TEMPLATE= "primaryJdbcTemplate";



    public static final String SECONDARY_YML_PREFIX = "database.secondary.datasource";
    public static final String SECONDARY_PERSISTENCE_UNIT= "database.secondary";
    public static final String SECONDARY_REPOSITORY_PREFIX = "com.nitheesh.mvc.secondary.repository";
    public static final String SECONDARY_DOMAIN_PREFIX = "com.nitheesh.mvc.secondary.domain";

    public static final String SECONDARY_DATA_SOURCE = "secondaryDataSource";
    public static final String SECONDARY_ENTITY_MANAGER_FACTORY_BEAN= "secondaryEntityManagerFactoryBean";
    public static final String SECONDARY_PLATFORM_TRANSACTION_MANAGER= "secondaryPlatformTransactionManager";
    public static final String SECONDARY_JDBC_TEMPLATE= "secondaryJdbcTemplate";
}
