package tr.com.mcay.springscope.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springscope.service.RequestBean;

@Tag(name = "Bean Scope API", description = "Spring'de bean kapsamlarını göstermek için API")
@RestController
@RequestMapping("/api")
public class RequestBeanController {
    private RequestBean requestBean;
    public RequestBeanController(RequestBean requestBean) {
        this.requestBean = requestBean;
    }
    @Operation(summary = "Request Scope Bean Mesajını Al", description = "Request kapsamındaki bean'den bir mesaj döner. Her HTTP isteğinde yeni bir bean oluşturulur. Request bean oluşturulurken proxy mode kullanılmıştır. Bootstrap sırasında konsola requestBean için initiazize mesajları yazılır fakat Bu, requestBean'in aslında bir proxy olarak başlatıldığını, ancak Spring'in bu proxy'yi oluşturduğu sırada BeanPostProcessor'un tetiklendiğini gösterir. Fakat dikkat edilmesi gereken nokta, burada gördüğünüz requestBean aslında bean'in kendisi değil, bir proxy nesnesidir. ")
    @GetMapping("/request")
    public String getRequestBean() {
        return requestBean.getMessage();
    }
}
