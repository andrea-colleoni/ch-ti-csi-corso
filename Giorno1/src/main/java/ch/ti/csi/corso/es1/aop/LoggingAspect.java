package ch.ti.csi.corso.es1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	// type designator (non supporta modifier, indica un tipo da intercettare
	@Pointcut("within(ch.ti.csi.corso.es1.impl.*Service)")
	public void serviziPointcut() {}
	
	// tutti i metodi del package
	@Pointcut("execution(* ch.ti.csi.corso.es1.impl.*.*(..))")
	public void packageImplPointcut() {}
	
	// tutti i metodi del package che iniziano con es*
	@Pointcut("execution(* ch.ti.csi.corso.es1.impl.*.es*(..))")
	public void metodiEsPointcut() {}
	
	// tutti i metodi annotati con una annotazione personalizzata
	@Pointcut("execution(@ch.ti.csi.corso.es1.aop.AOPAnnotation * *(..))")
	public void annotationPointcut() {}
	
	@Before("annotationPointcut()")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("prima di entrare nel metodo => " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* ch.ti.csi.corso.es1.impl.*.send(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("finito di eseguire il metodo => " + joinPoint.getSignature().getName());
	}
	
//	@Around("metodiEsPointcut()")
//	public void loggingAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("intercettato il metodo => " + joinPoint.getSignature().getName());
//		long millis = System.currentTimeMillis();
//		if ((millis % 2) == 0) {
//			joinPoint.proceed();
//			System.out.println(millis + " => proceed");
//		} else {
//			System.out.println(millis + " ! proceed");
//		}
//	}
//	
//	@AfterThrowing(pointcut= "metodiEsPointcut()", throwing= "error")
//	public void logErrori(JoinPoint joinPoint, Throwable error) {
//		System.out.println("nel metodo " + joinPoint.getSignature().getName() + 
//				"si è verificato un errore => " + error.getMessage());
//	}
}
