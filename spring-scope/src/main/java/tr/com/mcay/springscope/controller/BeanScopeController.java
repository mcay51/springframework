package tr.com.mcay.springscope.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springscope.service.SingletonBean;

@Tag(name = "Bean Scope API", description = "Spring'de bean kapsamlarını göstermek için API")
@RestController
@RequestMapping("/api")
public class BeanScopeController {

    private SingletonBean singletonBean;

    public BeanScopeController(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }
    @Operation(summary = "Singleton Bean Mesajını Al", description = "Singleton kapsamındaki bean'den bir mesaj döner.")
    @GetMapping("/singleton")
    public String getSingleton() {
        return singletonBean.getMessage();
    }
}
