package tr.com.mcay.springannotations.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

/**
 * @CircuitBreaker, bir işlemin çok fazla hataya neden olması durumunda, işlemi geçici olarak durdurup kesintiyi devreye sokar.
 * Bu sayede, başarısız olan bir kaynağa aşırı yüklenmeyi önler.
 */
@Service
public class CircuitBreakerService {
    private static final String BACKEND_A = "backendA";

    /**
     * @CircuitBreaker: Bu metod, çok fazla hata alırsa devre kesici mantığı devreye girecek.
     */
    @CircuitBreaker(name = BACKEND_A, fallbackMethod = "fallbackMethod")
    public String performUnstableTask(boolean fail) {
        if (fail) {
            throw new RuntimeException("Hata oluştu!");
        }
        return "İşlem başarılı!";
    }

    /**
     * @fallbackMethod: Devre kesici devreye girdiğinde bu metod çalışacak.
     */
    public String fallbackMethod(boolean fail, Throwable throwable) {
        return "Devre kesici devrede! Alternatif işlem yapılıyor.";
    }
}
