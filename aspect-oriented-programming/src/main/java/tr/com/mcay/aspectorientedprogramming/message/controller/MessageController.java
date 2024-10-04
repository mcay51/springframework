package tr.com.mcay.aspectorientedprogramming.message.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import tr.com.mcay.aspectorientedprogramming.message.service.MessageService;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/aop/message")
    public String getMessage() {
        return messageService.getMessage();
    }
}
