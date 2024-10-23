package tr.com.mcay.errorcodesimulation.service.impl;


import org.springframework.stereotype.Service;
import tr.com.mcay.errorcodesimulation.service.SuccessSimulationService;

@Service
public class SuccessSimulationServiceImpl implements SuccessSimulationService {

    @Override
    public String simulate200OK() {
        return "Custom 200 OK: İstek başarıyla işlendi.";
    }

    @Override
    public String simulate201Created() {
        return "Custom 201 Created: Yeni kaynak başarıyla oluşturuldu.";
    }

    @Override
    public String simulate204NoContent() {
        return "Custom 204 No Content: İstek başarıyla işlendi, döndürülecek içerik yok.";
    }
}
