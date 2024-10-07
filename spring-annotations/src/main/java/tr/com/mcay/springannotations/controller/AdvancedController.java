package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.RetryService;

@Tag(name = "AdvancedController", description = "AdvancedController API")
@RestController
@RequestMapping("/api")
public class AdvancedController {
    private final RetryService retryService;
    public AdvancedController(RetryService retryService) {
        this.retryService = retryService;
    }

    /**
     * @GetMapping: Retryable işlem kontrolü.
     */
    @GetMapping("/retry")
    @Operation(summary = "Yeniden deneme işlemi", description = "Bu endpoint ile hata durumunda işlemin yeniden denenmesini test edebilirsiniz.")
    public String retryOperation() {
        retryService.performRetryableTask();
        return "Retry işlemi tamamlandı.";
    }

}
