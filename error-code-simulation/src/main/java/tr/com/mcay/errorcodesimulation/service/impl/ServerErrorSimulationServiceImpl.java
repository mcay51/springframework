package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.com.mcay.errorcodesimulation.exceptions.ServerErrorException;
import tr.com.mcay.errorcodesimulation.service.ServerErrorSimulationService;

@Service
public class ServerErrorSimulationServiceImpl implements ServerErrorSimulationService {

    @Override
    public String simulate500InternalServerError() {
        throw new ServerErrorException(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "INTERNAL_SERVER_ERROR",
            "Sunucu isteği işlerken bir hata oluştu."
        );
    }

    @Override
    public String simulate501NotImplemented() {
        throw new ServerErrorException(
            HttpStatus.NOT_IMPLEMENTED,
            "NOT_IMPLEMENTED",
            "Sunucu, isteği yerine getirmek için gerekli olan işlevselliğe sahip değil."
        );
    }

    @Override
    public String simulate502BadGateway() {
        throw new ServerErrorException(
            HttpStatus.BAD_GATEWAY,
            "BAD_GATEWAY",
            "Geçerli bir yanıt alamayan bir üst sunucudan gelen hata."
        );
    }

    @Override
    public String simulate503ServiceUnavailable() {
        throw new ServerErrorException(
            HttpStatus.SERVICE_UNAVAILABLE,
            "SERVICE_UNAVAILABLE",
            "Sunucu geçici olarak hizmet veremiyor."
        );
    }

    @Override
    public String simulate504GatewayTimeout() {
        throw new ServerErrorException(
            HttpStatus.GATEWAY_TIMEOUT,
            "GATEWAY_TIMEOUT",
            "Üst sunucu isteğe yanıt vermedi."
        );
    }
}
