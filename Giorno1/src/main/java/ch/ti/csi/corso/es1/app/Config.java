package ch.ti.csi.corso.es1.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ch.ti.csi.corso.es1.aop.LoggingAspect;
import ch.ti.csi.corso.es1.impl.AbstractServizio;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = { AbstractServizio.class, LoggingAspect.class })
public class Config {

	@Bean
	public Client client() {
		return new Client();
	}

}
