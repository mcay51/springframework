package tr.com.mcay.springannotations.service;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Retryable, belirli hatalarla karşılaşıldığında bir işlemin belirli sayıda yeniden denenmesini sağlar.
 * Özellikle, ağ tabanlı işlemlerde veya geçici hatalarda tekrar deneyerek hataların üstesinden gelmek için kullanılır.
 */
@Service
public class RetryService {

    private int retryCount = 0;

    /**
     * @Retryable: Bu metod bir istisna fırlatırsa, 3 kez yeniden denenecek.
     */
    @Retryable(value = RuntimeException.class, maxAttempts = 3)
    public void performRetryableTask() {
        retryCount++;
        System.out.println("Deneme sayısı: " + retryCount);
        if (retryCount < 3) {
            throw new RuntimeException("Hata! Yeniden denenecek.");
        }
        if(retryCount == 4) {
            retryCount = 0;
        }
        System.out.println("İşlem başarılı!");
    }
}
