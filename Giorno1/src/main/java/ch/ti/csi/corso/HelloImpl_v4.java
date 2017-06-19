package ch.ti.csi.corso;

import java.util.Map;

public class HelloImpl_v4 implements HelloInterface {
	
	Map<String, Persona> persone;

	public HelloImpl_v4(Map<String, Persona> persone) {
		super();
		this.persone = persone;
	}

	public void hello() {
		for(String k : persone.keySet()) {
			System.out.println("Buonasera " + k);
		}
	}

}
