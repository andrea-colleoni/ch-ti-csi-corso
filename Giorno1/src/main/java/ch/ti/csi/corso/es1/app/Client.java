package ch.ti.csi.corso.es1.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

import ch.ti.csi.corso.es1.Servizio;

public class Client {
	
	@Autowired
	List<Servizio> servizi;
	
	public static void main(String[] args) {
		//1. impostazione e refresh context
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.getEnvironment().setActiveProfiles("prod");
//		ctx.register(Config.class);
//		ctx.refresh();
		
		//2. system env
		//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		Client c = (Client)ctx.getBean("client");
		c.go();
		ctx.close();
		
		//3. altre modalità (web.xml, WebAppInitializer)
	}
	
	public void go() {
		for(Servizio s : servizi)
			s.esegui();
	}
}
