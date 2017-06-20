package ch.ti.csi.corso.es1.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ch.ti.csi.corso.es1.Messaggistica;
import ch.ti.csi.corso.es1.Servizio;

public abstract class AbstractServizio implements Servizio {
	
	@Autowired
	List<Messaggistica> messaggistica;

	public abstract void esegui();

	void sendMessages(String messaggio) {
		for(Messaggistica m : messaggistica)
			m.send(messaggio);	
	}
	
}
