package tr.com.mcay.springscope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeBean {
    public String getMessage() {
        return "Bu bir prototype bean'dir!";
    }
}
