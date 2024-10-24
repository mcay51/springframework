package tr.com.mcay.springscope.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springscope.service.RequestBean;
import tr.com.mcay.springscope.service.SingletonBean;
import tr.com.mcay.springscope.service.factory.PrototypeBeanFactory;

@Tag(name = "Bean Scope API", description = "Spring'de bean kapsamlarını göstermek için API")
@RestController
@RequestMapping("/api")
public class BeanScopeController {

    private SingletonBean singletonBean;
    private PrototypeBeanFactory prototypeBeanFactory;

    public BeanScopeController(SingletonBean singletonBean, PrototypeBeanFactory prototypeBeanFactory, RequestBean requestBean) {
        this.singletonBean = singletonBean;
        this.prototypeBeanFactory = prototypeBeanFactory;
    }

    @Operation(summary = "Singleton Bean Mesajını Al", description = "Singleton kapsamındaki bean'den bir mesaj döner. Konsol çıktısını kontrol et. Proje ilk bootstrap olurken singleton bean için initialization mesajları yazar. Sonraki hiçbir çağrıda konsola initialization mesajı yazmaz.")
    @GetMapping("/singleton")
    public String getSingleton() {
        return singletonBean.getMessage();
    }
    @Operation(summary = "Prototype Bean Mesajını Al", description = "Prototype kapsamındaki bean'den bir mesaj döner. Konsol çıktısını kontrol et. Proje ilk bootstrap olurken prototype bean için konsola initialization mesajları yazmaz. Her metod çağrısında konsola initialization meajları yazar.")
    @GetMapping("/prototype")
    public String getPrototype() {
        // Her metot çağrısında yeni bir PrototypeBean oluşturuluyor.
        return prototypeBeanFactory.getPrototypeBean().getMessage();
    }
}
