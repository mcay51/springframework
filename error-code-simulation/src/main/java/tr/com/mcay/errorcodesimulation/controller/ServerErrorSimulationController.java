package tr.com.mcay.errorcodesimulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
    public void simulateInternalServerError() {
        errorSimulationService.simulate500InternalServerError();
    }

    @Operation(summary = "501 Not Implemented kodunu simüle eder", description = "Bu endpoint, 501 Not Implemented hata kodunu döner.")
    @ApiResponse(responseCode = "501", description = "Sunucu, isteği yerine getirmek için gerekli olan işlevselliğe sahip değil.")
    @GetMapping("/501")
    public void simulateNotImplemented() {
        errorSimulationService.simulate501NotImplemented();
    }

    @Operation(summary = "502 Bad Gateway kodunu simüle eder", description = "Bu endpoint, 502 Bad Gateway hata kodunu döner.")
    @ApiResponse(responseCode = "502", description = "Geçerli bir yanıt alamayan bir üst sunucudan gelen hata.")
    @GetMapping("/502")
    public void simulateBadGateway() {
        errorSimulationService.simulate502BadGateway();
    }

    @Operation(summary = "503 Service Unavailable kodunu simüle eder", description = "Bu endpoint, 503 Service Unavailable hata kodunu döner.")
    @ApiResponse(responseCode = "503", description = "Sunucu geçici olarak hizmet veremiyor.")
    @GetMapping("/503")
    public void simulateServiceUnavailable() {
        errorSimulationService.simulate503ServiceUnavailable();
    }

    @Operation(summary = "504 Gateway Timeout kodunu simüle eder", description = "Bu endpoint, 504 Gateway Timeout hata kodunu döner.")
    @ApiResponse(responseCode = "504", description = "Üst sunucu isteğe yanıt vermedi.")
    @GetMapping("/504")
    public void simulateGatewayTimeout() {
        errorSimulationService.simulate504GatewayTimeout();
    }
}
