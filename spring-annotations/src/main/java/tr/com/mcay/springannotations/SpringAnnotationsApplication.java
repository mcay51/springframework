package tr.com.mcay.springannotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication, Spring Boot uygulaması için en temel annotation’dır. Bu, aslında üç annotation'ın birleşimidir:
 * * @Configuration: Spring IoC container için konfigürasyon sınıfı olduğunu belirtir.
 * * @EnableAutoConfiguration: Spring Boot’un otomatik konfigürasyon yapmasını sağlar.
 * * @ComponentScan: Belirtilen paket içerisindeki @Component, @Service, @Repository gibi bean'lerin otomatik olarak taranmasını sağlar.
 */

@SpringBootApplication
public class SpringAnnotationsApplication {
    // @SpringBootApplication: Bu annotation, Spring Boot uygulamasının başlangıç noktasıdır. Uygulama başlarken SpringApplication.run() ile başlatılır.
    public static void main(String[] args) {
        SpringApplication.run(SpringAnnotationsApplication.class, args);
    }

}
