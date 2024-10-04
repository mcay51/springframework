package tr.com.mcay.dependencyinjection.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.dependencyinjection.message.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageControllerFieldBased {
    //Field-Based injection
    @Autowired
    private  MessageService messageService = null;

    @GetMapping("/message-field-based")
    public String messageFieldBased() {
        return messageService.getMessage();
    }
}
