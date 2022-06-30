package org.nikithra.aranidhi.framework.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	static Logger log = Logger.getLogger(LoggingAspect.class.getName());

	// for classes with four package structure
	@Before("execution(* org.nikithra.aranidhi.*.*.*.*(..))")
	public void before(JoinPoint point) {
		log.debug("Class Name :"
				+ point.getSignature().getDeclaringType().getName()
				+ ",Calling " + point.getSignature().getName() + "() method.");

	}

	@After("execution(* org.nikithra.aranidhi.*.*.*.*(..))")
	public void afterMethodCalled(JoinPoint point) {
		log.debug("Class Name :"
				+ point.getSignature().getDeclaringType().getName() + ","
				+ point.getSignature().getName() + " has finished execution.");

	}

	@AfterThrowing(pointcut = "execution(* org.nikithra.aranidhi.*.*.*.*(..))", throwing = "e")
	public void throwsAspect(JoinPoint point, Throwable e) {
		log.error("Class Name :"
				+ point.getSignature().getDeclaringType().getName() + ","
				+ point.getSignature().getName() + " has throwed " + e
				+ ",cause is :" + e.getCause() + ".");
		log.debug("Class Name :"
				+ point.getSignature().getDeclaringType().getName() + ","
				+ point.getSignature().getName() + " has throwed " + e
				+ ",cause is :" + e.getCause() + ".");
		log.info("Class Name :"
				+ point.getSignature().getDeclaringType().getName() + ","
				+ point.getSignature().getName() + " has throwed " + e
				+ ",cause is :" + e.getCause() + ".");

	}

	@AfterReturning(pointcut = "execution(* org.nikithra.aranidhi.*.*.*.*(..))", returning = "ret")
	public void returnValues(JoinPoint point, Object ret) {

		log.debug("Class Name :"
				+ point.getSignature().getDeclaringType().getName() + ","
				+ point.getSignature().getName() + " return "
				+ point.getSignature().getDeclaringType().getName() + ".");

	}

}

