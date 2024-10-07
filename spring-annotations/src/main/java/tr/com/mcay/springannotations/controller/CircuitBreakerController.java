package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.CircuitBreakerService;

@Tag(name = "AdvancedController", description = "AdvancedController API")
@RestController
@RequestMapping("/api")
public class CircuitBreakerController {
    private final CircuitBreakerService circuitBreakerService;
    public CircuitBreakerController(CircuitBreakerService circuitBreakerService) {
        this.circuitBreakerService = circuitBreakerService;
    }
    /**
     * @GetMapping: CircuitBreaker işlem kontrolü.
     */
    @GetMapping("/circuit-breaker")
    @Operation(summary = "Devre kesici kontrolü", description = "Bu endpoint ile devre kesici mantığını test edebilirsiniz.")
    public String circuitBreakerOperation(@RequestParam boolean fail) {
        return circuitBreakerService.performUnstableTask(fail);
    }
}
