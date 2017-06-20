package ch.ti.csi.corso.es1.impl;

import org.springframework.stereotype.Service;

@Service
public class InstallazionService extends AbstractServizio {

	public void esegui() throws Exception {
		long millis = System.currentTimeMillis();
		if ((millis % 2) == 0) {
			errore();
		}
		String messaggio = "Eseguita l'installazione";
		System.out.println(messaggio);
		sendMessages(messaggio);
	}

}
