package tr.com.mcay.springannotations.service;

import org.springframework.stereotype.Service;

/**
 * @Service: Bu sınıf bir servis katmanı sınıfıdır ve iş mantığını içerir.
 */
@Service
public class HelloService {
    /**
     * İş mantığı: Kullanıcıya "Merhaba" mesajı döner.
     */
    public String getHelloMessage() {
        return "Merhaba, Servis Katmanından!";
    }
}
