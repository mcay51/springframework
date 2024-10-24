package tr.com.mcay.springscope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class SingletonBean {
    public String getMessage() {
        return "This is a singleton bean!";
    }
}
