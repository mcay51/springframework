package tr.com.mcay.springannotations.service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
/**
 * @Service: Request kapsamlı bir bean.
 * @Scope("request"): Her HTTP isteği için yeni bir bean örneği oluşturur.
 */
@Service
@Scope("request")
public class RequestScopeService {
    public RequestScopeService() {
        System.out.println("RequestScopedService oluşturuldu.");
    }

    public String getRequestScopeMessage() {
        return "Bu bir Request scoped bean örneğidir!";
    }
}
