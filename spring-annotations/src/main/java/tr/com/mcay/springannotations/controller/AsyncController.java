package tr.com.mcay.springannotations.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.AsyncService;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "AsyncController", description = "AsyncController API")
/**
 * @RestController: Bu sınıf bir REST API controller'ıdır.
 */
@RestController
@RequestMapping("/api")
public class AsyncController {

    private final AsyncService asyncService;

    /**
     * @Autowired: Asenkron servisi controller'a enjekte eder.
     */
    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    /**
     * @GetMapping("/async"): Bu metot asenkron çalışır ve sonucu gelecekte döner.
     * @Operation: Swagger dokümantasyonu için metod açıklaması sağlar.
     */
    @Operation(summary = "Asenkron işlemi başlatır", description = "Asenkron olarak çalışan bir metodu çağırır ve işlemin tamamlanmasını bekler.")
    @GetMapping("/async")
    public CompletableFuture<String> callAsyncMethod() throws InterruptedException {
        return asyncService.asyncMethod();
    }
}
