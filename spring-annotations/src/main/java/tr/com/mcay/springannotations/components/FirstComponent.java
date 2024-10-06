package tr.com.mcay.springannotations.components;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Component: Spring konteynerine bir bileşen olarak kaydeder.
 * @Order(1): Bu bileşen sıralamada 1. önceliğe sahip.
 */
@Component
@Order(1)
public class FirstComponent {


    public String getMessage() {
        return "Order Birinci Bileşen Mesajı";
    }
}
