package ch.ti.csi.corso;

public class HelloImpl_AutoWiring implements HelloInterface {
	
	Persona luigi;

	public void hello() {
		System.out.println("Buonasera " + luigi.getCognome());
	}

	public void setLuigi(Persona andrea) {
		this.luigi = andrea;
	}

}
