package tr.com.mcay.errorcodesimulation.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.com.mcay.errorcodesimulation.exceptions.RedirectException;
import tr.com.mcay.errorcodesimulation.service.RedirectSimulationService;

@Service
public class RedirectSimulationServiceImpl implements RedirectSimulationService {

    @Override
    public String simulate300MultipleChoices() {
        throw new RedirectException(
            HttpStatus.MULTIPLE_CHOICES,
            "MULTIPLE_CHOICES",
            "Birden fazla olası kaynak mevcut."
        );
    }

    @Override
    public String simulate301MovedPermanently() {
        throw new RedirectException(
            HttpStatus.MOVED_PERMANENTLY,
            "MOVED_PERMANENTLY",
            "Kaynak kalıcı olarak taşındı."
        );
    }

    @Override
    public String simulate302Found() {
        throw new RedirectException(
            HttpStatus.FOUND,
            "FOUND",
            "Kaynak geçici olarak taşındı."
        );
    }
}
