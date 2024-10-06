package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.*;

@Tag(name = "BeanScopeController", description = "BeanScopeController API")
/**
 * @RestController: RESTful web servisleri için bir denetleyici.
 */
@RestController
@RequestMapping("/api")
public class BeanScopeController {
    /**
     * Uygulamada bootstrap sırasında singletonService den 1 örnek oluşturulurken prototypeService için iki örnek oluşturulacaktır.
     */
    private final SingletonService singletonService;
    private final PrototypeService prototypeService;
    private final SingletonService singletonService1;
    private final PrototypeService prototypeService1;


    public BeanScopeController(SingletonService singletonService, PrototypeService prototypeService, SingletonService singletonService1, PrototypeService prototypeService1) {
        this.singletonService = singletonService;
        this.prototypeService = prototypeService;
        this.singletonService1 = singletonService1;
        this.prototypeService1 = prototypeService1;


    }

    /**
     * Singleton ve Prototype servislerinden mesaj döner.
     * @return Mesajlar.
     */
    @GetMapping("/scope-messages")
    @Operation(summary = "Singleton ve Prototype", description = "SingletonService ve PrototypeService Scope davranışlarını test eder.")
    public String getScopeMessages() {
        return singletonService.getSingletonMessage() + " | " + prototypeService.getPrototypeMessage() + " | " + singletonService1.getSingletonMessage() + " | " + prototypeService1.getPrototypeMessage();
    }



}
