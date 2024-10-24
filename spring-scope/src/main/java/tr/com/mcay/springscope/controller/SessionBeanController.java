package tr.com.mcay.springscope.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springscope.service.SessionBean;

@Tag(name = "Bean Scope API", description = "Spring'de bean kapsamlarını göstermek için API")
@RestController
@RequestMapping("/api")
public class SessionBeanController {
    private SessionBean sessionBean;

    public SessionBeanController(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    @Operation(summary = "Session Scope Bean Mesajını Al", description = "Session kapsamındaki bean'den bir mesaj döner. Kullanıcı oturumu boyunca aynı bean örneği kullanılır.")
    @GetMapping("/session")
    public String getSessionBean() {
        return sessionBean.getMessage();
    }
}
