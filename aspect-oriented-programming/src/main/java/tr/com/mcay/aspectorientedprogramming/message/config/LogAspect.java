package tr.com.mcay.aspectorientedprogramming.message.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
        logger.info("Before Method {} is about to be called", joinPoint.getSignature().getName());
    }

    // Metod tamamlandıktan sonra loglama yapıyor.
    @After("controllerMethods()")
    public void logAfter(JoinPoint joinPoint) {

        logger.info("Method {} has been called -1", joinPoint.getSignature().getName());
        logger.info("Method {} has been called -2", joinPoint.getSignature().getDeclaringType().getName());
        logger.info("Method {} has been called -3", joinPoint.getSignature().getDeclaringTypeName());
        logger.info("Method {} has been called -4", joinPoint.getArgs());
        logger.info("Method {} has been called -5", joinPoint.getKind().toString());
        logger.info("Method {} has been called -6", joinPoint.getTarget().getClass().getName());

        // Temel bilgiler
        System.out.println("Metot: " + joinPoint.getSignature().getName());
        System.out.println("Sınıf: " + joinPoint.getSignature().getDeclaringTypeName());

        // Metot parametreleri
        System.out.println("Parametreler: " + Arrays.toString(joinPoint.getArgs()));

        // Hedef nesne
        System.out.println("Hedef nesne: " + joinPoint.getTarget());

        // AOP proxy
        System.out.println("AOP proxy: " + joinPoint.getThis());


        // Detaylı string gösterimi
        System.out.println("JoinPoint detayları: " + joinPoint.toLongString());

        // MethodSignature kullanımı (eğer bir metot ise)
        if (joinPoint.getSignature() instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            System.out.println("Dönüş tipi: " + methodSignature.getReturnType());
            System.out.println("Parametre adları: " + Arrays.toString(methodSignature.getParameterNames()));
            System.out.println("Parametre tipleri: " + Arrays.toString(methodSignature.getParameterTypes()));
        }
        try {
            // Kaynak kodu bilgisi
            SourceLocation sourceLocation = joinPoint.getSourceLocation();
            System.out.println("Dosya: " + sourceLocation.getFileName());
            System.out.println("Satır: " + sourceLocation.getLine());
        } catch (RuntimeException e) {
           // throw new RuntimeException(e);
        }
    }
    // Metodun hem öncesinde hem de sonrasında işlem yapılmasını sağlıyor.
    @Around("controllerMethods()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Around Method {} execution starts", proceedingJoinPoint.getSignature().getName());
        Object result = proceedingJoinPoint.proceed();  // Continue with the method execution
        logger.info("Around Method {} execution ends", proceedingJoinPoint.getSignature().getName());
        return result;
    }
}

