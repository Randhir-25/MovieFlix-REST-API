package com.shubhamyeole;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.shubhamyeole.entity");
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(properties());
		return emf;
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3178228");
		ds.setUsername("sql3178228");
		ds.setPassword("Nfqr4HKU2m");
		return ds;
	}

	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf){
		JpaTransactionManager jtm = new JpaTransactionManager(emf);

		return jtm;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	private Properties properties(){
		Properties  props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//		props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		props.setProperty("hibernate.hbm2ddl.auto", "validate");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.format_sql", "true");
		return props;

	}
}
