package com.springjpa.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = { "com.springjpa.dao" })
public class PersistenceConfig {

	@Bean
	public DataSource dataSource(@Value("${db.driverClassname}") String driverClassname, @Value("${db.url}") String url,
			@Value("${db.username}") String username, @Value("${db.password}") String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClassname);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = null;
		HibernateJpaVendorAdapter hibernateJpaVendor = null;

		entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);

		hibernateJpaVendor = new HibernateJpaVendorAdapter();
		hibernateJpaVendor.setShowSql(true);
		hibernateJpaVendor.setGenerateDdl(true);
		entityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendor);
		entityManagerFactoryBean.setPackagesToScan("com.springjpa.entities");

		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public JpaTemplate jpaTemplate(EntityManagerFactory entityManagerFactory) {
		JpaTemplate jpaTemplate = new JpaTemplate(entityManagerFactory);
		return jpaTemplate;
	}
}
