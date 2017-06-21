package ch.ti.csi.corso.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaDialect;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(order=0)
@ComponentScan(basePackageClasses={ch.ti.csi.corso.jpa.Studente.class} )
public class Config {

//	@Bean
//	public EntityManagerFactory localEntityManagerFactory() {
//		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
//		emf.setPersistenceUnitName("corsi");
//		return emf.getNativeEntityManagerFactory();
//	}
	
	@Bean
	public JpaTransactionManager txManager() {
		JpaTransactionManager tx = new JpaTransactionManager();
		tx.setDataSource(jdbcDataSource());
		tx.setJpaDialect(new HibernateJpaDialect());
		tx.setEntityManagerFactory(entityManagerFactory().getObject());
		return tx;
	}
	
	@Bean
	@Scope("prototype")
	public EntityManager entityManager() {
		return entityManagerFactory().getObject().createEntityManager();
	}
	
	@Bean
	//public LocalContainerEntityManagerFactoryBean containerEntityManagerFactory() {
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabase(Database.POSTGRESQL);
		emf.setJpaVendorAdapter(adapter);
		Map<String, String> jpaProperties = new HashMap<String, String>();
		jpaProperties.put("eclipselink.weaving", "false");
		emf.setJpaPropertyMap(jpaProperties);
		//emf.setDataSource(pooledDataSource());
		emf.setPersistenceUnitName("corsi");
		//emf.setPackagesToScan("ch.ti.csi.corso.jpa");
		return emf;
	}
	
//	@Bean
//	public DataSource jndiDataSource() {
//		JndiObjectFactoryBean ds = new JndiObjectFactoryBean();
//		ds.setJndiName("/jdbc/corsi");
//		return (DataSource) ds;
//	}
	
	@Bean
	public DataSource pooledDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriver(new Driver());
		ds.setUrl("jdbc:postgresql://dev.sdi.ti.ch:15432/corso_spring");
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		ds.setInitialSize(5);
		ds.setMaxTotal(20);
		return ds;
	}	
	
	@Bean
	public DataSource jdbcDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://dev.sdi.ti.ch:15432/corso_spring");
		ds.setUsername("postgres");
		ds.setPassword("postgres");
		return ds;
	}		
}
