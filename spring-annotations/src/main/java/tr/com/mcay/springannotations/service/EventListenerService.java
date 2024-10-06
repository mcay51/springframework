package tr.com.mcay.springannotations.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import tr.com.mcay.springannotations.events.CustomEvent;

/**
 * @Service: Olayları dinleyen bir servis sınıfı.
 */
@Service
public class EventListenerService {

    /**
     * @EventListener: Bu metot, CustomEvent olaylarını dinler.
     */
    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("Olay Mesajı Event Listener Tarafından İşlendi : " + event.getMessage());
    }
}