package tr.com.mcay.springannotations.service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
/**
 * @Service: Singleton bir bean.
 * @Scope("singleton"): Bu bean uygulama boyunca tek bir örneğe sahip olur. (varsayılan scope).
 */
@Service
@Scope("singleton")
public class SingletonService {

    public SingletonService() {
        System.out.println("SingletonService oluşturuldu.");
    }

    public String getSingletonMessage() {
        return "Bu bir Singleton bean örneğidir!";
    }
}