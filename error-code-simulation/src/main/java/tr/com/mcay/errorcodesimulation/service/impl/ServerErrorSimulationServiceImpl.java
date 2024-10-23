package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.stereotype.Service;
import tr.com.mcay.errorcodesimulation.service.ServerErrorSimulationService;
@Service
public class ServerErrorSimulationServiceImpl implements ServerErrorSimulationService {

    @Override
    public String simulate500InternalServerError() {
        throw new RuntimeException("Custom 500 Internal Server Error: Sunucu isteği işlerken bir hata oluştu.");
    }

    @Override
    public String simulate501NotImplemented() {
        throw new UnsupportedOperationException("Custom 501 Not Implemented: Sunucu, isteği yerine getirmek için gerekli olan işlevselliğe sahip değil.");
    }

    @Override
    public String simulate502BadGateway() {
        throw new RuntimeException("Custom 502 Bad Gateway: Geçerli bir yanıt alamayan bir üst sunucudan gelen hata.");
    }

    @Override
    public String simulate503ServiceUnavailable() {
        throw new RuntimeException("Custom 503 Service Unavailable: Sunucu geçici olarak hizmet veremiyor.");
    }

    @Override
    public String simulate504GatewayTimeout() {
        throw new RuntimeException("Custom 504 Gateway Timeout: Üst sunucu isteğe yanıt vermedi.");
    }
}
