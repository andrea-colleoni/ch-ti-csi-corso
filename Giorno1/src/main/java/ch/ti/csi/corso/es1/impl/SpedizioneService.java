package ch.ti.csi.corso.es1.impl;

import org.springframework.stereotype.Service;

import ch.ti.csi.corso.es1.Servizio;
import ch.ti.csi.corso.es1.aop.Notifiable;

@Service
public class SpedizioneService implements Servizio {

	@Notifiable("Notifica di eseguita spedizione")
	public void esegui() {
		String messaggio = "Eseguita la spedizione";
		System.out.println(messaggio);
	}

}
