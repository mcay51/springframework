package tr.com.mcay.springannotations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import tr.com.mcay.springannotations.events.CustomEvent;

/**
 * @Service: Olay yayımlayan bir servis sınıfı.
 */
@Service
public class EventPublisherService {

    private final ApplicationEventPublisher publisher;

    /**
     * @Autowired: ApplicationEventPublisher bean'ini enjekte eder.
     */
    @Autowired
    public EventPublisherService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    /**
     * Bir olay yayımlar.
     * @param message Olay mesajı.
     */
    public void publishEvent(String message) {
        CustomEvent event = new CustomEvent(message);
        publisher.publishEvent(event);
    }
}