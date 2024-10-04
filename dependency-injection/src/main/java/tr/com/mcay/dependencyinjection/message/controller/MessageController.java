package tr.com.mcay.dependencyinjection.message.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.dependencyinjection.message.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;
    // Constructor-based injection
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping("/message")
    public String message() {
        return messageService.getMessage();
    }
}
