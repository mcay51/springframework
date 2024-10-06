package tr.com.mcay.springannotations.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Aspect: AOP için bir kesim.
 * @Component: Spring konteynerine bir bileşen olarak kaydeder.
 * @Order(2): Bu kesim sıralamada 2. önceliğe sahip.
 */
@Aspect
@Component
@Order(2)
public class AnotherLogAspect {

    @Before("execution(* tr.com.mcay.springannotations.controller.*.*(..))")
    public void logBefore() {
        System.out.println("AnotherLogAspect: Before Metot çalıştırıldı.");
    }

    @After("execution(* tr.com.mcay.springannotations.controller.*.*(..))")
    public void logAfter() {
        System.out.println("AnotherLogAspect: After Metot çalıştırıldı.");
    }
}
