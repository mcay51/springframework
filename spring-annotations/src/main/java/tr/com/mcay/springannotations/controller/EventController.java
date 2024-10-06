package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.EventPublisherService;

@Tag(name = "EventController", description = "EventController API")
/**
 * @RestController: Olay yayımlayan bir controller.
 */
@RestController
@RequestMapping("/api")
public class EventController {

    private final EventPublisherService publisherService;

    /**
     * @Autowired: Olay yayımlama servisini enjekte eder.
     */
    @Autowired
    public EventController(EventPublisherService publisherService) {
        this.publisherService = publisherService;
    }

    /**
     * @GetMapping("/publishEvent"): Olay yayımlar.
     * @Operation: Swagger dokümantasyonu için metod açıklaması sağlar.
     */
    @Operation(summary = "Olay yayımlar", description = "Bir olay yayımlar ve dinleyici tarafından işlenir.")
    @GetMapping("/publishEvent")
    public String publishEvent(@RequestParam String message) {
        publisherService.publishEvent(message);
        return "Olay Yayımlandı!";
    }
}
