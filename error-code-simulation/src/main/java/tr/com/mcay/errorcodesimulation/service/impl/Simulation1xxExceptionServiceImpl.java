package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.com.mcay.errorcodesimulation.exceptions.InformationException;
import tr.com.mcay.errorcodesimulation.service.Simulation1xxExceptionService;

@Service
public class Simulation1xxExceptionServiceImpl implements Simulation1xxExceptionService {

    @Override
    public String simulate100Continue() {
        throw new InformationException(
            HttpStatus.CONTINUE,
            "CONTINUE",
            "İstek devam ediyor."
        );
    }

    @Override
    public String simulate101SwitchingProtocols() {
        throw new InformationException(
            HttpStatus.SWITCHING_PROTOCOLS,
            "SWITCHING_PROTOCOLS",
            "Protokol değiştiriliyor."
        );
    }

    @Override
    public String simulate102Processing() {
        throw new InformationException(
            HttpStatus.PROCESSING,
            "PROCESSING",
            "İşlem devam ediyor."
        );
    }
}
