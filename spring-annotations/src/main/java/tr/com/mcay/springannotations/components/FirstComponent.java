package tr.com.mcay.springannotations.components;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Component: Spring konteynerine bir bileşen olarak kaydeder.
 * @Order(1): Bu bileşen sıralamada 1. önceliğe sahip.
 */
@Component
@Order(1)
public class FirstComponent {
    /**
     * @PostConstruct anotasyonu, bir bean’in yaşam döngüsünde "başlatıldıktan hemen sonra" çalıştırılacak bir metodu tanımlar.
     * Bean, bağımlılıklarının enjekte edilmesinden sonra, yani bean başlatıldıktan sonra bu metod çağrılır.
     */
    @PostConstruct
    public void init() {
        // Bean başlatıldıktan hemen sonra yapılacak işlemler
        System.out.println("FirstComponent Initialization başlatıldı ve veritabanı bağlantısı kuruldu!");
    }

    public String getMessage() {
        return "Order Birinci Bileşen Mesajı";
    }

    /**
     * @PreDestroy anotasyonu, bir bean’in yok edilmeden önce çalıştırılacak olan metodu tanımlar.
     * Bu metod, bean sonlandırılmadan hemen önce çağrılır ve temizleme işlemleri (örn. kaynakları serbest bırakma) için kullanılır.
     */
    @PreDestroy
    public void cleanup() {
        // Bean yok edilmeden önce yapılacak işlemler
        System.out.println("CleanupService bean sonlandırılıyor, kaynaklar serbest bırakılıyor!");
    }
}
