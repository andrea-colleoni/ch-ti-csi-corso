package ch.ti.csi.corso.es1.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.ti.csi.corso.es1.impl.AbstractServizio;

@Configuration
@ComponentScan(basePackageClasses={AbstractServizio.class})
public class Config {
	
	@Bean
	public Client client() {
		return new Client();
	}

}
