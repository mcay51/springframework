package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.stereotype.Service;
import tr.com.mcay.errorcodesimulation.service.Simulation1xxExceptionService;
@Service
public class Simulation1xxExceptionServiceImpl implements Simulation1xxExceptionService {

    @Override
    public String simulate100Continue() {
        return "Custom Continue: İşlem devam ediyor.";
    }

    @Override
    public String simulate101SwitchingProtocols() {
        return "Custom Switching Protocols: Protokol değiştiriliyor.";
    }

    @Override
    public String simulate102Processing() {
        return "Custom Processing: İşlem devam ediyor.";
    }
}
