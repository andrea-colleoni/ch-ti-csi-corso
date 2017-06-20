package ch.ti.csi.corso.es1.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch.ti.csi.corso.es1.Messaggistica;

@Service
@Qualifier("asincrona")
public class EmailMessages implements Messaggistica {

	public void send(String messaggio) {
		System.out.println("Mail => " + messaggio);

	}

}
