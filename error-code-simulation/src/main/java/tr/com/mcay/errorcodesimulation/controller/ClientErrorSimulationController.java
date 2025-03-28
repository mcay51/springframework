package tr.com.mcay.errorcodesimulation.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import tr.com.mcay.errorcodesimulation.service.ClientErrorSimulationService;

@RestController
@RequestMapping("/api/v1/error-simulation")
@Tag(name = "4xx Client Error Simulation API", description = "4xx hata kodlarının simülasyonu için API")
public class ClientErrorSimulationController {

    private final ClientErrorSimulationService errorSimulationService;

    @Autowired
    public ClientErrorSimulationController(ClientErrorSimulationService errorSimulationService) {
        this.errorSimulationService = errorSimulationService;
    }

    @Operation(summary = "400 Bad Request kodunu simüle eder", description = "Bu endpoint, 400 Bad Request hata kodunu döner.")
    @ApiResponse(responseCode = "400", description = "İstemciden gelen istek geçersiz.")
    @GetMapping("/400")
    public void simulateBadRequest() {
        errorSimulationService.simulate400BadRequest();
    }

    @Operation(summary = "401 Unauthorized kodunu simüle eder", description = "Bu endpoint, 401 Unauthorized hata kodunu döner.")
    @ApiResponse(responseCode = "401", description = "İstek yetkilendirilmemiş.")
    @GetMapping("/401")
    public void simulateUnauthorized() {
        errorSimulationService.simulate401Unauthorized();
    }

    @Operation(summary = "403 Forbidden kodunu simüle eder", description = "Bu endpoint, 403 Forbidden hata kodunu döner.")
    @ApiResponse(responseCode = "403", description = "İstemci isteği yasaklı bir kaynak için.")
    @GetMapping("/403")
    public void simulateForbidden() {
        errorSimulationService.simulate403Forbidden();
    }

    @Operation(summary = "404 Not Found kodunu simüle eder", description = "Bu endpoint, 404 Not Found hata kodunu döner.")
    @ApiResponse(responseCode = "404", description = "İstenen kaynak bulunamadı.")
    @GetMapping("/404")
    public void simulateNotFound() {
        errorSimulationService.simulate404NotFound();
    }
}

