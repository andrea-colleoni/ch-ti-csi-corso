package ch.ti.csi.corso.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.ti.csi.corso.Persona;

@Component
public class Servizio1 implements BeanNameAware {
	
	@Autowired
	private Persona luigi;

	public void a() {
		System.out.println("Servizio1.a() / " + luigi.getNome());
	}

	public void setBeanName(String arg0) {
		System.out.println(arg0);
	}
}
