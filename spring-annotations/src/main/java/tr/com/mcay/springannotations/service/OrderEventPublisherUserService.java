package tr.com.mcay.springannotations.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tr.com.mcay.springannotations.events.OrderUserCreatedEvent;

/**
 * @Service: Servis katmanını temsil eder.
 * Kullanıcı oluşturma işlemini gerçekleştirir.
 */
@Service
public class OrderEventPublisherUserService {

    private final ApplicationEventPublisher eventPublisher;

    public OrderEventPublisherUserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * Yeni kullanıcı oluştur ve olayı yayınla.
     * @param username Kullanıcı adı.
     */
    public void createUser(String username) {
        System.out.println("Kullanıcı oluşturuluyor: " + username);

        // Kullanıcı oluşturma olayı tetikleniyor.
        eventPublisher.publishEvent(new OrderUserCreatedEvent(username));
    }
}