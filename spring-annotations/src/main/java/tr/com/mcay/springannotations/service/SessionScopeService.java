package tr.com.mcay.springannotations.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Service: Session kapsamlı bir bean.
 * @Scope("session"): Her kullanıcı oturumu için yeni bir bean örneği oluşturur.
 */
@Service
@Scope("session")
public class SessionScopeService {
    public SessionScopeService() {
        System.out.println("SessionScopedService oluşturuldu.");
    }

    public String getSessionScopeMessage() {
        return "Bu bir Session scoped bean örneğidir!";
    }
}
