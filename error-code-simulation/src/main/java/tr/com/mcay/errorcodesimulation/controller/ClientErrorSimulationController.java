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
import tr.com.mcay.errorcodesimulation.service.ClientErrorSimulationService;

@RestController
@RequestMapping("/api/v1/error-simulation")
@Tag(name = "Client Error Simulation API 4xx", description = "4xx hata kodlarının simülasyonu için API")
public class ClientErrorSimulationController {

    private final ClientErrorSimulationService errorSimulationService;

    @Autowired
    public ClientErrorSimulationController(ClientErrorSimulationService errorSimulationService) {
        this.errorSimulationService = errorSimulationService;
    }

    @Operation(summary = "400 Bad Request kodunu simüle eder", description = "Bu endpoint, 400 Bad Request hata kodunu döner.")
    @ApiResponse(responseCode = "400", description = "İstemciden gelen istek geçersiz.")
    @GetMapping("/400")
    public ResponseEntity<String> simulateBadRequest() {
        String message = errorSimulationService.simulate400BadRequest();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @Operation(summary = "401 Unauthorized kodunu simüle eder", description = "Bu endpoint, 401 Unauthorized hata kodunu döner.")
    @ApiResponse(responseCode = "401", description = "İstek yetkilendirilmemiş.")
    @GetMapping("/401")
    public ResponseEntity<String> simulateUnauthorized() {
        String message = errorSimulationService.simulate401Unauthorized();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }

    @Operation(summary = "403 Forbidden kodunu simüle eder", description = "Bu endpoint, 403 Forbidden hata kodunu döner.")
    @ApiResponse(responseCode = "403", description = "İstemci isteği yasaklı bir kaynak için.")
    @GetMapping("/403")
    public ResponseEntity<String> simulateForbidden() {
        String message = errorSimulationService.simulate403Forbidden();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(message);
    }

    @Operation(summary = "404 Not Found kodunu simüle eder", description = "Bu endpoint, 404 Not Found hata kodunu döner.")
    @ApiResponse(responseCode = "404", description = "İstenen kaynak bulunamadı.")
    @GetMapping("/404")
    public ResponseEntity<String> simulateNotFound() {
        String message = errorSimulationService.simulate404NotFound();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}

