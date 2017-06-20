package ch.ti.csi.corso.es1.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ch.ti.csi.corso.es1.Messaggistica;

@Service
@Qualifier("istantanea")
@Profile("dev")
public class WhatsAppMessages implements Messaggistica {

	public void send(String messaggio) {
		System.out.println("WhatsApp => " + messaggio);

	}

}
