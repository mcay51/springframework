package tr.com.mcay.dependencyinjection.message.service.impl;

import org.springframework.stereotype.Service;
import tr.com.mcay.dependencyinjection.message.service.MessageService;

@Service
public class ServiceMessageImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Hello Spring Framework";
    }
}
