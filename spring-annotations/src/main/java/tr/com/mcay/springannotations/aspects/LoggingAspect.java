package tr.com.mcay.springannotations.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Aspect: AOP için bir kesim.
 * @Component: Spring konteynerine bir bileşen olarak kaydeder.
 * @Order(1): Bu kesim sıralamada 1. önceliğe sahip.
 */
@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Before("execution(* tr.com.mcay.springannotations.controller.*.*(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before Metot çalıştırıldı.");
    }

    @After("execution(* tr.com.mcay.springannotations.controller.*.*(..))")
    public void logAfter() {
        System.out.println("LoggingAspect: After Metot çalıştırıldı.");
    }
}