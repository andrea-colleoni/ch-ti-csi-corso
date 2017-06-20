package ch.ti.csi.corso.es1.impl;

import org.springframework.stereotype.Service;

import ch.ti.csi.corso.es1.Servizio;
import ch.ti.csi.corso.es1.aop.Notifiable;
import ch.ti.csi.corso.outofcontainer.ServizioOut;

@Service
public class InstallazioneService implements Servizio {

	@Notifiable("Notifica di eseguita installazione")
	public void esegui() throws Exception {
//		long millis = System.currentTimeMillis();
//		if ((millis % 2) == 0) {
//			errore();
//		}
		String messaggio = "Eseguita l'installazione";
		System.out.println(messaggio);
		
		ServizioOut so = new ServizioOut();
		so.metodo();
	}

}
