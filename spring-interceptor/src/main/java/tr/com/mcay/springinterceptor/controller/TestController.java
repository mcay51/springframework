package tr.com.mcay.springinterceptor.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Spring Interceptor Simulation API", description = "Spring Interceptor simülasyonu için API")
public class TestController {
    @Operation(summary = "Interceptor için request kodunu simüle eder", description = "Bu endpoint, Interceptor için request kodunu simüle eder")
    @ApiResponse(responseCode = "200", description = "Pre Handle method is called. URI: /api/api/hello      ***" +
            "Post Handle method is called.        ***" +
            "afterCompletion : Request and Response is completed.")
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from the API!";
    }
}
