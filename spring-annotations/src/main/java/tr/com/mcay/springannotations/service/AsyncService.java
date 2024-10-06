package tr.com.mcay.springannotations.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @Service: Bu sınıf asenkron iş mantığını içerir.
 */
@Service
public class AsyncService {
    /**
     * @Async: Bu metot asenkron olarak çalışır.
     * @return CompletableFuture<String>: Asenkron sonuç döner.
     */
    @Async
    public CompletableFuture<String> asyncMethod() throws InterruptedException {
        Thread.sleep(3000); // Simülasyon amacıyla 3 saniyelik bir bekleme.
        return CompletableFuture.completedFuture("Asenkron İşlem Tamamlandı!");
    }
}
