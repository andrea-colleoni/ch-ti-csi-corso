package ch.ti.csi.corso.es1.aop;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.ti.csi.corso.es1.Messaggistica;

@Aspect
@Component
public class NotificationAspect {
	
	@Autowired
	List<Messaggistica> messaggistica;	

	@Pointcut("execution(@ch.ti.csi.corso.es1.aop.Notifiable * *(..))")
	public void notifyPointcut() {}
	
	@Pointcut("execution(* ch.ti.csi.corso.es1.impl.*.esegui(..))")
	public void eseguiPointcut() {}	
	
	@After("notifyPointcut() && @annotation(notifiable)")
	public void notify(JoinPoint jp , Notifiable notifiable) {
		sendMessages(notifiable.value());
	}
	
	private void sendMessages(String messaggio) {
		for(Messaggistica m : messaggistica)
			m.send(messaggio);	
	}
}
