package ch.ti.csi.corso.es1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch.ti.csi.corso.es1.Messaggistica;

@Service
public class SpedizioneService extends AbstractServizio {

	@Autowired
	@Qualifier("istantanea")
	Messaggistica sms;
	
	public void esegui() {
		String messaggio = "Eseguita la spedizione";
		System.out.println(messaggio);
		sms.send(messaggio);
	}

}
