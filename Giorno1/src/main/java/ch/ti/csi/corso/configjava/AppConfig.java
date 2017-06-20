package ch.ti.csi.corso.configjava;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ch.ti.csi.corso.beans.Servizio1;

@Configuration
@ComponentScan(basePackageClasses=Servizio1.class)
public class AppConfig {
	
	@Bean
	public Persona andrea() {
		return new Persona("Andrea", "Colleoni");
	}
	
	@Bean
	public Persona luigi() {
		return new Persona("Luigi", "Rossi");
	}
	
	@Bean
	public ch.ti.csi.corso.Persona mario() {
		return new ch.ti.csi.corso.Persona("Mario", "Verdi");
	}
	
	@Bean
	public HelloInterface salutaUno() {
		return new HelloImpl(luigi());
	}
	
	@Bean(autowire=Autowire.BY_NAME)
	public HelloInterface salutaAW() {
		return new HelloImpl_AutoWiring();
	}
	@Bean
	public ClientApp client() {
		return new ClientApp(salutaAW());
	}

}
