package tr.com.mcay.springannotations.service;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tr.com.mcay.springannotations.events.OrderUserCreatedEvent;

/**
 * @Component: Spring konteynerine bir bileşen olarak kaydeder.
 * @Order(1): Bu dinleyici ilk sırada çalıştırılacak.
 */
@Component
public class OrderEventListenerUserWelcomeService {
    @EventListener
    @Order(1)  // İlk olarak bu dinleyici çalışır.
    public void handleUserCreated(OrderUserCreatedEvent event) {
        System.out.println("Order 1 Event Olayı Gerçekleşti ->Hoş geldin mesajı gönderiliyor: " + event.getUsername());
    }
}
