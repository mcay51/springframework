package tr.com.mcay.errorcodesimulation.service;

public interface ClientErrorSimulationService {
    String simulate400BadRequest();
    String simulate401Unauthorized();
    String simulate403Forbidden();
    String simulate404NotFound();
}
