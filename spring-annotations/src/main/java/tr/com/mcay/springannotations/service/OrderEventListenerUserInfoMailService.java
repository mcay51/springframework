package tr.com.mcay.springannotations.service;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tr.com.mcay.springannotations.events.OrderUserCreatedEvent;

/**
 * @Component: Spring konteynerine bir bileşen olarak kaydeder.
 * @Order(2): Bu dinleyici ikinci sırada çalıştırılacak.
 */
@Component
public class OrderEventListenerUserInfoMailService {
    @EventListener
    @Order(2)  // İkinci olarak bu dinleyici çalışır.
    public void handleUserCreated(OrderUserCreatedEvent event) {
        System.out.println("Order 2 Event Olayı Gerçekleşti -> Bilgilendirme maili gönderiliyor: " + event.getUsername());
    }
}
