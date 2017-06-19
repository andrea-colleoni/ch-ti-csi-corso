package ch.ti.csi.corso;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientApp {
	
	HelloInterface hi;
	
	public ClientApp(HelloInterface hi) {
		super();
		this.hi = hi;
	}

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("/beans.xml");
		ClientApp c = (ClientApp)ctx.getBean("client");
		c.go();
		ctx.close();
	}
	
	void go() {
		hi.hello();
	}

//	public void setHi(HelloImpl_AutoWiring hi) {
//		this.hi = hi;
//	}

}
