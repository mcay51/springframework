package tr.com.mcay.springannotations.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @Service: Global Session kapsamlı bir bean.
 * @Scope("globalSession"): Global session (özellikle portlet uygulamaları için) kapsamlı bir bean.
 * Eğer portlet tabanlı bir uygulama geliştiriyorsanız ve globalSession kullanmaya zorunluysanız spring-webportlet bağımlılığını eklemeniz gerekir.
 * Genellikle session scope kullanmak yeterlidir ve bu, çoğu web uygulaması için daha yaygın bir yaklaşımdır.
 * Eğer uygulamanın tasarımını daha basit tutmak istersen, globalSession kullanmaktan kaçınmak en iyisi olacaktır.
 */
@Service
@Scope("globalSession")
public class GlobalSessionScopeService {
    public GlobalSessionScopeService() {
        System.out.println("GlobalSessionScopedService oluşturuldu.");
    }
    public String getGlobalSessionScopedMessage() {
        return "Bu bir Global Session scoped bean örneğidir!";
    }
}
