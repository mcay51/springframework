package tr.com.mcay.errorcodesimulation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.errorcodesimulation.service.RedirectSimulationService;

@RestController
@RequestMapping("/api/v1/redirect-simulation")
@Tag(name = "Redirect Simulation API 3xx", description = "3xx yönlendirme kodlarının simülasyonu için API")
public class RedirectSimulationController {

    private final RedirectSimulationService redirectSimulationService;

    @Autowired
    public RedirectSimulationController(RedirectSimulationService redirectSimulationService) {
        this.redirectSimulationService = redirectSimulationService;
    }

    @Operation(summary = "300 Multiple Choices kodunu simüle eder", description = "Bu endpoint, 300 Multiple Choices kodunu döner.")
    @ApiResponse(responseCode = "300", description = "Birden fazla olası kaynak mevcut.")
    @GetMapping("/300")
    public ResponseEntity<String> simulateMultipleChoices() {
        String message = redirectSimulationService.simulate300MultipleChoices();
        return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES).body(message);
    }

    @Operation(summary = "301 Moved Permanently kodunu simüle eder", description = "Bu endpoint, 301 Moved Permanently kodunu döner.")
    @ApiResponse(responseCode = "301", description = "Kaynak kalıcı olarak taşındı.")
    @GetMapping("/301")
    public ResponseEntity<String> simulateMovedPermanently() {
        String message = redirectSimulationService.simulate301MovedPermanently();
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).body(message);
    }

    @Operation(summary = "302 Found kodunu simüle eder", description = "Bu endpoint, 302 Found kodunu döner.")
    @ApiResponse(responseCode = "302", description = "Kaynak geçici olarak taşındı.")
    @GetMapping("/302")
    public ResponseEntity<String> simulateFound() {
        String message = redirectSimulationService.simulate302Found();
        return ResponseEntity.status(HttpStatus.FOUND).body(message);
    }
}
