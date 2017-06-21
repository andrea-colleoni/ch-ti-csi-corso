package ch.ti.csi.corso.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ch.ti.csi.corso.config.Config;

@Component
public class ClientApp {
	
	@Autowired
	Servizio s;
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ClientApp c = ctx.getBean(ClientApp.class);
		c.go();
		ctx.close();
	}
	
	@Transactional
	void go() {
		s.go();
	}



}
