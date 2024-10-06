package tr.com.mcay.springannotations.components;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Component: Spring konteynerine bir bileşen olarak kaydeder.
 * @Order(2): Bu bileşen sıralamada 2. önceliğe sahip.
 */
@Component
@Order(2)
public class SecondComponent  {

    public String getMessage() {
        return "Order İkinci Bileşen Mesajı";
    }
}