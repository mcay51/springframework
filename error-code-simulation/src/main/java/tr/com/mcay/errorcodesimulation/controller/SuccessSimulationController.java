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
import tr.com.mcay.errorcodesimulation.service.SuccessSimulationService;

@RestController
@RequestMapping("/api/v1/success-simulation")
@Tag(name = "2xx Simulation API Success", description = "2xx başarı kodlarının simülasyonu için API")
public class SuccessSimulationController {

    private final SuccessSimulationService successSimulationService;

    @Autowired
    public SuccessSimulationController(SuccessSimulationService successSimulationService) {
        this.successSimulationService = successSimulationService;
    }

    @Operation(summary = "200 OK kodunu simüle eder", description = "Bu endpoint, 200 OK başarı kodunu döner.")
    @ApiResponse(responseCode = "200", description = "İstek başarıyla işlendi.")
    @GetMapping("/200")
    public ResponseEntity<String> simulateOK() {
        String message = successSimulationService.simulate200OK();
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @Operation(summary = "201 Created kodunu simüle eder", description = "Bu endpoint, 201 Created başarı kodunu döner.")
    @ApiResponse(responseCode = "201", description = "Yeni kaynak başarıyla oluşturuldu.")
    @GetMapping("/201")
    public ResponseEntity<String> simulateCreated() {
        String message = successSimulationService.simulate201Created();
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @Operation(summary = "204 No Content kodunu simüle eder", description = "Bu endpoint, 204 No Content başarı kodunu döner.")
    @ApiResponse(responseCode = "204", description = "İstek başarıyla işlendi, ancak içerik yok.")
    @GetMapping("/204")
    public ResponseEntity<String> simulateNoContent() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  // No Content için gövde yok
    }
}
