package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.com.mcay.errorcodesimulation.exceptions.ClientErrorException;
import tr.com.mcay.errorcodesimulation.service.ClientErrorSimulationService;

@Service
public class ClientErrorSimulationServiceImpl implements ClientErrorSimulationService {

    @Override
    public String simulate400BadRequest() {
        throw new ClientErrorException(
            HttpStatus.BAD_REQUEST,
            "BAD_REQUEST",
            "İstemciden gelen istek geçersiz."
        );
    }

    @Override
    public String simulate401Unauthorized() {
        throw new ClientErrorException(
            HttpStatus.UNAUTHORIZED,
            "UNAUTHORIZED",
            "İstek yetkilendirilmemiş."
        );
    }

    @Override
    public String simulate403Forbidden() {
        throw new ClientErrorException(
            HttpStatus.FORBIDDEN,
            "FORBIDDEN",
            "İstemci isteği yasaklı bir kaynak için."
        );
    }

    @Override
    public String simulate404NotFound() {
        throw new ClientErrorException(
            HttpStatus.NOT_FOUND,
            "NOT_FOUND",
            "İstenen kaynak bulunamadı."
        );
    }
}
