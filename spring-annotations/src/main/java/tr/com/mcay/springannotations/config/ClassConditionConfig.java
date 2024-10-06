package tr.com.mcay.springannotations.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration: Konfigürasyon sınıfını belirtir.
 * @ConditionalOnClass: Bu anotasyon, yalnızca belirli bir sınıf classpath'te mevcut olduğunda bean'in yaratılmasını sağlar.
 * Özellikle dış bağımlılıklara göre (örneğin, bir kütüphane yüklü mü değil mi) davranış sergilemek için kullanılır.
 * Bu bean, 'com.fasterxml.jackson.databind.ObjectMapper' sınıfı mevcutsa yaratılacak.
 */
@Configuration
public class ClassConditionConfig {

    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    public String jacksonBean() {
        return "Jackson ObjectMapper is present!";
    }
}
