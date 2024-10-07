package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.OrderService;
@Tag(name = "OrderController", description = "OrderController API")
/**
 * @Profile, belirli bir profile ait bean'leri belirtmek için kullanılır.
 * Örneğin, bir uygulamanın geliştirme ve prodüksiyon ortamlarında farklı konfigürasyonları olabilir.
 */
@RestController
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    // Constructor-based injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @Operation(summary = "Aktif profile göre bean seçimi", description = "Aktif profil tipine göre dev test prod aktif profile bean  yüklenir")
    @GetMapping("/order-profile")
    public String placeOrder() {
        return orderService.placeOrder();
    }
}