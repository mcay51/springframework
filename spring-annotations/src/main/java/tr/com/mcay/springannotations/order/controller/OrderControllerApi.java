package tr.com.mcay.springannotations.order.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.order.dto.OrderDTO;
import tr.com.mcay.springannotations.order.service.OrderService;
@Tag(name = "Sipariş Yönetimi", description = "Sipariş işlemlerini yöneten API")
@RestController
@RequestMapping("/api/orders")
public class OrderControllerApi {

    private OrderService orderService;

    public OrderControllerApi(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Yeni Sipariş Oluştur", description = "Yeni bir sipariş oluşturur. {\n" +
            "  \"customerName\": \"Jane Doe\",\n" +
            "  \"products\": [\n" +
            "    {\n" +
            "      \"name\": \"Telefon\",\n" +
            "      \"price\": 800.0\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Kulaklık\",\n" +
            "      \"price\": 150.0\n" +
            "    }\n" +
            "  ]\n" +
            "}")
    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.placeOrder(orderDTO));
    }
}
