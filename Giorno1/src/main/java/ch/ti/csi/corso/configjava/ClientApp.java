package ch.ti.csi.corso.configjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import ch.ti.csi.corso.beans.Servizio1;

public class ClientApp {  
	
	HelloInterface hi;
	
	@Autowired
	Servizio1 servizio1;
	
	public ClientApp(HelloInterface hi) {
		super();
		this.hi = hi;
	}

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ClientApp c = (ClientApp)ctx.getBean("client");
		c.go();
		ctx.close();
	}
	
	void go() {
		servizio1.a();
		hi.hello();
	}

//	public void setHi(HelloImpl_AutoWiring hi) {
//		this.hi = hi;
//	}

}
