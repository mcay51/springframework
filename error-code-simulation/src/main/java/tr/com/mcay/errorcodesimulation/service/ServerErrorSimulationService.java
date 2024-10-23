package tr.com.mcay.errorcodesimulation.service;

public interface ServerErrorSimulationService {

        String simulate500InternalServerError();
        String simulate501NotImplemented();
        String simulate502BadGateway();
        String simulate503ServiceUnavailable();
        String simulate504GatewayTimeout();
}
