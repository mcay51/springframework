package tr.com.mcay.springannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @SpringBootApplication, Spring Boot uygulaması için en temel annotation’dır. Bu, aslında üç annotation'ın birleşimidir:
 * * @Configuration: Spring IoC container için konfigürasyon sınıfı olduğunu belirtir.
 * * @EnableAutoConfiguration: Spring Boot’un otomatik konfigürasyon yapmasını sağlar.
 * * @ComponentScan: Belirtilen paket içerisindeki @Component, @Service, @Repository gibi bean'lerin otomatik olarak taranmasını sağlar.
 * @EnableAsync: Asenkron işlemleri etkinleştirir.
 */

@SpringBootApplication
@EnableAsync
@EnableScheduling  // Zamanlanmış görevleri etkinleştirir
@EnableRetry  // Hata fırlatan metodun belirlenen deneme sayısı kadar tekrar çalıştırılabilmesi için Retry işlemini etkinleştirir
@EnableCaching // Caching etkinleştirir
public class SpringAnnotationsApplication {
    // @SpringBootApplication: Bu annotation, Spring Boot uygulamasının başlangıç noktasıdır. Uygulama başlarken SpringApplication.run() ile başlatılır.
    public static void main(String[] args) {
        SpringApplication.run(SpringAnnotationsApplication.class, args);
    }

}
