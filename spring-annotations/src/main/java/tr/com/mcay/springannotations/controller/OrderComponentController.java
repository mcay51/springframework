package tr.com.mcay.springannotations.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.components.*;

@Tag(name = "OrderController", description = "OrderController API")
/**
 * @RestController: RESTful web servisleri için bir denetleyici.
 */
@RestController
@RequestMapping("/api")
public class OrderComponentController {

    private final FirstComponent firstComponent;
    private final SecondComponent secondComponent;

    public OrderComponentController(FirstComponent firstComponent, SecondComponent secondComponent) {
        this.firstComponent = firstComponent;
        this.secondComponent = secondComponent;
    }

    /**
     * Bileşenlerden mesajları döner.
     * @return Mesajlar.
     */
    @GetMapping("/order-component-messages")
    @Operation(summary = "Order", description = "Componentler için Order anotasyonu uygulaması.")
    public String getComponentMessages() {
        return firstComponent.getMessage() + " | " + secondComponent.getMessage();
    }
}

