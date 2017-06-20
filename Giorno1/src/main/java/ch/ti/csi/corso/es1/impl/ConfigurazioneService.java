package ch.ti.csi.corso.es1.impl;

import org.springframework.stereotype.Service;

import ch.ti.csi.corso.es1.Servizio;
import ch.ti.csi.corso.es1.aop.Notifiable;

@Service
public class ConfigurazioneService implements Servizio {

	@Notifiable("Notifica di eseguita configurazione")
	public void esegui() throws Exception {
		System.out.println("Eseguito il servizio di configurazione");

	}

}
