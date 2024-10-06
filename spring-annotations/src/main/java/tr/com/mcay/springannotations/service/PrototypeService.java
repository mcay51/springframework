package tr.com.mcay.springannotations.service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
/**
 * @Service: Prototype kapsamlı bir bean.
 * @Scope("prototype"): Her çağrıda yeni bir bean örneği oluşturur.
 */
@Service
@Scope("prototype")
public class PrototypeService {

    public PrototypeService() {
        System.out.println("PrototypeService oluşturuldu.");
    }

    public String getPrototypeMessage() {
        return "Bu bir Prototype bean örneğidir!";
    }
}
