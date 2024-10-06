package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.OrderEventPublisherUserService;
@Tag(name = "OrderController", description = "OrderController API")
/**
 * @RestController: RESTful web servisleri için bir denetleyici.
 */
@RestController
@RequestMapping("/api")
public class OrderEventUserController {
    private final OrderEventPublisherUserService orderEventPublisherUserService;
    public OrderEventUserController(OrderEventPublisherUserService orderEventPublisherUserService) {
        this.orderEventPublisherUserService = orderEventPublisherUserService;
    }

    /**
     * Kullanıcı oluşturma işlemini gerçekleştirir.
     * @param username Kullanıcı adı.
     * @return Oluşturma durumu.
     */
    @GetMapping("/create-user")
    @Operation(summary = "Kullanıcı oluşturur", description = "Belirtilen kullanıcı adını alır ve bir kullanıcı oluşturur.")
    public String createUser(@RequestParam String username) {
        orderEventPublisherUserService.createUser(username);
        return "Kullanıcı başarıyla oluşturuldu: " + username;
    }
}