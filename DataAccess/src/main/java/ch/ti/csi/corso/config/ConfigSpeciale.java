package ch.ti.csi.corso.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ConfigSpeciale extends Config {

//	@Bean
//	@Qualifier("corsi_2")
//	public AbstractEntityManagerFactoryBean entityManagerFactory() {
//		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
//		emf.setPersistenceUnitName("corsi_2");
//		return emf;
//	}
	
	

}
