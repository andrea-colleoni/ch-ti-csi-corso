package ch.ti.csi.corso.es1.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import ch.ti.csi.corso.es1.Messaggistica;
import ch.ti.csi.corso.es1.aop.AOPAnnotation;

@Service
@Qualifier("istantanea")
@Profile("prod")
public class SMSMessages implements Messaggistica {

	@AOPAnnotation
	public void send(String messaggio) {
		System.out.println("SMS => " + messaggio);

	}
}
