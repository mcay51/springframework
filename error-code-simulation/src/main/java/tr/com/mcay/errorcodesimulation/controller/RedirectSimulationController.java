package tr.com.mcay.errorcodesimulation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import tr.com.mcay.errorcodesimulation.service.RedirectSimulationService;

@RestController
@RequestMapping("/api/v1/redirect-simulation")
@Tag(name = "3xx Redirect Simulation API", description = "3xx yönlendirme kodlarının simülasyonu için API")
public class RedirectSimulationController {

    private final RedirectSimulationService redirectSimulationService;

    @Autowired
    public RedirectSimulationController(RedirectSimulationService redirectSimulationService) {
        this.redirectSimulationService = redirectSimulationService;
    }

    @Operation(summary = "300 Multiple Choices kodunu simüle eder", description = "Bu endpoint, 300 Multiple Choices kodunu döner.")
    @ApiResponse(responseCode = "300", description = "Birden fazla olası kaynak mevcut.")
    @GetMapping("/300")
    public void simulateMultipleChoices() {
        redirectSimulationService.simulate300MultipleChoices();
    }

    @Operation(summary = "301 Moved Permanently kodunu simüle eder", description = "Bu endpoint, 301 Moved Permanently kodunu döner.")
    @ApiResponse(responseCode = "301", description = "Kaynak kalıcı olarak taşındı.")
    @GetMapping("/301")
    public void simulateMovedPermanently() {
        redirectSimulationService.simulate301MovedPermanently();
    }

    @Operation(summary = "302 Found kodunu simüle eder", description = "Bu endpoint, 302 Found kodunu döner.")
    @ApiResponse(responseCode = "302", description = "Kaynak geçici olarak taşındı.")
    @GetMapping("/302")
    public void simulateFound() {
        redirectSimulationService.simulate302Found();
    }
}
