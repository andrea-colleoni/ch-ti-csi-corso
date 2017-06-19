package ch.ti.csi.corso;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloImpl implements HelloInterface, BeanNameAware, BeanFactoryAware, ApplicationContextAware,
		InitializingBean, DisposableBean {

	Persona persona;

	public HelloImpl(Persona persona) {
		super();
		this.persona = persona;
	}

	public void hello() {
		System.out.println("Ciao " + persona.getNome());
	}


	public void setBeanName(String nomeBean) {
		System.out.println("log... setBeanName => " + nomeBean);

	}

	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("log... setBeanFactory => " + arg0.getClass().getName());
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("log... setApplicationContext => " + arg0.getClass().getName());
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("log... afterPropertiesSet ");
	}

	public void destroy() throws Exception {
		System.out.println("log... destroy ");
	}

}
