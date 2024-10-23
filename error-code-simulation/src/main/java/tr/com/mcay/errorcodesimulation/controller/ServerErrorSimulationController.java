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
import tr.com.mcay.errorcodesimulation.service.ServerErrorSimulationService;

@RestController
@RequestMapping("/api/v1/error-simulation")
@Tag(name = "5xx Server Error Simulation API", description = "5xx hata kodlarının simülasyonu için API")
public class ServerErrorSimulationController {

    private final ServerErrorSimulationService errorSimulationService;

    @Autowired
    public ServerErrorSimulationController(ServerErrorSimulationService errorSimulationService) {
        this.errorSimulationService = errorSimulationService;
    }

    @Operation(summary = "500 Internal Server Error kodunu simüle eder", description = "Bu endpoint, 500 Internal Server Error hata kodunu döner.")
    @ApiResponse(responseCode = "500", description = "Sunucu isteği işlerken bir hata oluştu.")
    @GetMapping("/500")
    public ResponseEntity<String> simulateInternalServerError() {
        String message = errorSimulationService.simulate500InternalServerError();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }

    @Operation(summary = "501 Not Implemented kodunu simüle eder", description = "Bu endpoint, 501 Not Implemented hata kodunu döner.")
    @ApiResponse(responseCode = "501", description = "Sunucu, isteği yerine getirmek için gerekli olan işlevselliğe sahip değil.")
    @GetMapping("/501")
    public ResponseEntity<String> simulateNotImplemented() {
        String message = errorSimulationService.simulate501NotImplemented();
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(message);
    }

    @Operation(summary = "502 Bad Gateway kodunu simüle eder", description = "Bu endpoint, 502 Bad Gateway hata kodunu döner.")
    @ApiResponse(responseCode = "502", description = "Geçerli bir yanıt alamayan bir üst sunucudan gelen hata.")
    @GetMapping("/502")
    public ResponseEntity<String> simulateBadGateway() {
        String message = errorSimulationService.simulate502BadGateway();
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(message);
    }

    @Operation(summary = "503 Service Unavailable kodunu simüle eder", description = "Bu endpoint, 503 Service Unavailable hata kodunu döner.")
    @ApiResponse(responseCode = "503", description = "Sunucu geçici olarak hizmet veremiyor.")
    @GetMapping("/503")
    public ResponseEntity<String> simulateServiceUnavailable() {
        String message = errorSimulationService.simulate503ServiceUnavailable();
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(message);
    }

    @Operation(summary = "504 Gateway Timeout kodunu simüle eder", description = "Bu endpoint, 504 Gateway Timeout hata kodunu döner.")
    @ApiResponse(responseCode = "504", description = "Üst sunucu isteğe yanıt vermedi.")
    @GetMapping("/504")
    public ResponseEntity<String> simulateGatewayTimeout() {
        String message = errorSimulationService.simulate504GatewayTimeout();
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(message);
    }
}
