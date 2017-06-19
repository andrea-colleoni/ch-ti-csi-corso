package ch.ti.csi.corso;

public class HelloImpl_v2 implements HelloInterface {

	Persona persona;
	
	public void hello() {
		System.out.println("Buonasera " + persona.getCognome());
	}

	public void setPersona(Persona p) {
		this.persona = p;	
	}
}
