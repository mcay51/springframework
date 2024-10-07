package tr.com.mcay.springannotations.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Component, Spring'in genel amaçlı bir anotasyonudur ve bir sınıfın Spring IoC container'ına bean olarak tanıtılmasını sağlar.
 * Servis, repository veya configuration gibi özel anotasyonlar da aslında @Component'in alt kümesidir.
 * @Lazy, bir bean'in yalnızca gerektiği zaman yaratılmasını sağlar.
 * Bu, uygulamanın başlatılma sürecini hızlandırabilir ve bellekte gereksiz yük oluşturmasını önler.
 */
@Component
@Lazy
public class LazyResourceService {
    public LazyResourceService() {
        System.out.println("Lazy kaynak başlatıldı.");
    }
    public void process() {
        System.out.println("Lazy kaynak işleniyor.");
    }
}
