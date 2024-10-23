package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.stereotype.Service;
import tr.com.mcay.errorcodesimulation.service.ClientErrorSimulationService;
@Service
public class ClientErrorSimulationServiceImpl implements ClientErrorSimulationService {
    @Override
    public String simulate400BadRequest() {
        return "Custom 400 Bad Request: İstemciden gelen istek geçersiz.";
    }

    @Override
    public String simulate401Unauthorized() {
        return "Custom 401 Unauthorized: İstek yetkilendirilmemiş.";
    }

    @Override
    public String simulate403Forbidden() {
        return "Custom 403 Forbidden: İstemci isteği yasaklı bir kaynak için.";
    }

    @Override
    public String simulate404NotFound() {
        return "Custom 404 Not Found: İstenen kaynak bulunamadı.";
    }
}
