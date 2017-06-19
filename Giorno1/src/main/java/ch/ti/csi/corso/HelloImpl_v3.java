package ch.ti.csi.corso;

import java.util.Collection;

public class HelloImpl_v3 implements HelloInterface {

	Collection<Persona> persone;

	public HelloImpl_v3(Collection<Persona> persone) {
		super();
		this.persone = persone;
	}

	public void hello() {
		for(Persona p : persone) {
			System.out.println("Buonasera " + p.getCognome());
		}

	}

}
