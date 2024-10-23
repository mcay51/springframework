package tr.com.mcay.errorcodesimulation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.errorcodesimulation.service.Simulation1xxExceptionService;

@RestController
@RequestMapping("/api/v1/simulation")
@Tag(name = "1xx Simulation API", description = "1xx hata kodlarının simülasyonu için API")
public class Simulation1xxExceptionController {
    private final Simulation1xxExceptionService simulationService;
    public Simulation1xxExceptionController(Simulation1xxExceptionService simulationService) {
        this.simulationService = simulationService;
    }
    // 100 Continue simülasyonu
    @Operation(summary = "100 Continue kodunu simüle eder", description = "Bu endpoint, 100 Continue hata kodunu döner.")
    @ApiResponse(responseCode = "100", description = "İstek devam ediyor.")
    @GetMapping("/100")
    public ResponseEntity<String> simulateContinue() {
        String message = simulationService.simulate100Continue();
        return ResponseEntity.status(HttpStatus.CONTINUE)
                .body(message);
    }

    // 101 Switching Protocols simülasyonu
    @Operation(summary = "101 Switching Protocols kodunu simüle eder", description = "Bu endpoint, 101 Switching Protocols hata kodunu döner.")
    @ApiResponse(responseCode = "101", description = "Protokol değiştiriliyor.")
    @GetMapping("/101")
    public ResponseEntity<String> simulateSwitchingProtocols() {
        String message = simulationService.simulate101SwitchingProtocols();
        return ResponseEntity.status(HttpStatus.SWITCHING_PROTOCOLS)
                .body(message);
    }

    // 102 Processing simülasyonu
    @Operation(summary = "102 Processing kodunu simüle eder", description = "Bu endpoint, 102 Processing hata kodunu döner.")
    @ApiResponse(responseCode = "102", description = "İşlem devam ediyor.")
    @GetMapping("/102")
    public ResponseEntity<String> simulateProcessing() {
        String message = simulationService.simulate102Processing();
        return ResponseEntity.status(HttpStatus.PROCESSING)
                .body(message);
    }

    // Custom bir hata durumu yaratma
    @GetMapping("/error")
    public ResponseEntity<String> simulateError() {
        throw new RuntimeException("Custom bir hata oluştu!");
    }
}
