package tr.com.mcay.springscope.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestBean {
    public RequestBean() {
        System.out.println("Gerçek RequestBean initialized");
    }
    public String getMessage() {
        return "Bu bir request scope bean'dir!";
    }
}
