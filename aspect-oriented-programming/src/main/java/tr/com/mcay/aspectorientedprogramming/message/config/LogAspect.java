package tr.com.mcay.aspectorientedprogramming.message.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // Belirli bir pattern'e uyan metodları hedefliyor. Bu örnekte, controller paketindeki tüm metodlar hedefleniyor.
    @Pointcut("execution(* tr.com.mcay.aspectorientedprogramming.message.controller.*.*(..))")
    public void controllerMethods() {}

    // Metod çağrılmadan önce loglama yapılmasını sağlıyor.
    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Method {} is about to be called", joinPoint.getSignature().getName());
    }

    // Metod tamamlandıktan sonra loglama yapıyor.
    @After("controllerMethods()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Method {} has been called", joinPoint.getSignature().getName());
    }

    // Metodun hem öncesinde hem de sonrasında işlem yapılmasını sağlıyor.
    @Around("controllerMethods()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Method {} execution starts", proceedingJoinPoint.getSignature().getName());
        Object result = proceedingJoinPoint.proceed();  // Continue with the method execution
        logger.info("Method {} execution ends", proceedingJoinPoint.getSignature().getName());
        return result;
    }
}

