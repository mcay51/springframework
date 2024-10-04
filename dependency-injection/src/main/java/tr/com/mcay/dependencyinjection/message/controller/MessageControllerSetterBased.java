package tr.com.mcay.dependencyinjection.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.dependencyinjection.message.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageControllerSetterBased {
    //Setter-Based injection
    private MessageService messageService;
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping("/message-setter-based")
    public String messageSetterBased() {
        return messageService.getMessage();
    }
}
