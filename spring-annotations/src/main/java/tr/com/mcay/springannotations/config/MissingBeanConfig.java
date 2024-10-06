package tr.com.mcay.springannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;


/**
 * @Configuration: Konfigürasyon sınıfını belirtir.
 * @ConditionalOnMissingBean: Bu anotasyon, yalnızca belirli bir bean mevcut değilse yeni bir bean oluşturur.
 * Bu, uygulamada bir bean'in tanımlanıp tanımlanmadığını kontrol etmek ve eksik olduğunda alternatif bir yapı oluşturmak için kullanılır.
 * Bu bean, 'myService' bean'i mevcut değilse yaratılacak.
 */
@Configuration
public class MissingBeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "myService")
    public String defaultService() {
        return "Default Service Bean";
    }
}
