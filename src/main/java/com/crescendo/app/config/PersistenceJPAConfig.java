package com.crescendo.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@ComponentScan(basePackages="com.crescendo.app")ll
*/public class PersistenceJPAConfig {
	
	
	static {
		System.out.println("In PersistenceJPAConfig class");
	}
	
	
	public PersistenceJPAConfig() {
        super();
    }

	@Bean
	   public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println("In entityManagerFactory method");
	      LocalContainerEntityManagerFactoryBean entityManagerFactoryBean 
	        = new LocalContainerEntityManagerFactoryBean();
	      entityManagerFactoryBean.setDataSource(dataSource());
	      entityManagerFactoryBean.setPackagesToScan(new String[] { "com.crescendo.app.core.components" });
	 
	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
	      entityManagerFactoryBean.setJpaProperties(additionalProperties());
	      //entityManagerFactoryBean.setPersistenceUnitName("crescendo_pu");
	      return entityManagerFactoryBean;
	   }
	
	@Bean
	public DataSource dataSource(){
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");	
	    dataSource.setUrl("jdbc:mysql://localhost:3306/test");
	    dataSource.setUsername( "root" );
	    dataSource.setPassword( "venu23" );
	    return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
	    final JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	 
	    return transactionManager;
	}
	 
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	 
	Properties additionalProperties() {
	    Properties properties = new Properties();
	    properties.setProperty("spring.jpa.hibernate.ddl-auto", "update");
	    properties.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	    properties.setProperty("spring.jpa.show-sql", "true");
	    return properties;
	}

}
