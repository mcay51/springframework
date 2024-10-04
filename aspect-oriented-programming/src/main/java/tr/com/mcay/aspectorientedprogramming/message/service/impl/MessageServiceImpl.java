package tr.com.mcay.aspectorientedprogramming.message.service.impl;

import org.springframework.stereotype.Service;
import tr.com.mcay.aspectorientedprogramming.message.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public String getMessage() {
        return "Spring Framework Aspect Oriented Programming Message";
    }
}
