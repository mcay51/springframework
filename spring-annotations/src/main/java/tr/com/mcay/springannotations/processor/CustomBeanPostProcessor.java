package tr.com.mcay.springannotations.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Component: Spring'in yönetimine aldığı bir bean'dir.
 * @BeanPostProcessor: Bu sınıf, Spring container'da tüm bean'lerin oluşturulma aşamasını kontrol eder.
 * Spring’in bean lifecycle (bean yaşam döngüsü) işlemlerini özelleştirmek için kullanılan bir ara yüzdür.
 * Bir bean, oluşturulmadan önce ya da oluşturulduktan sonra özel işlemler gerçekleştirmek amacıyla bu anotasyonu kullanabiliriz.
 * @BeanPostProcessor, Spring container tarafından her bean yaratıldığında çağrılır.
 */

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    /**
     * Bean yaratılmadan önce işlem yapar.
     * @param bean: Yaratılacak bean
     * @param beanName: Bean'in adı
     * @return İşlenmiş ya da orijinal bean
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean " + beanName + " yaratılmadan önce işlem yapılıyor...");
        return bean;
    }

    /**
     * Bean yaratıldıktan sonra işlem yapar.
     * @param bean: Yaratılan bean
     * @param beanName: Bean'in adı
     * @return İşlenmiş ya da orijinal bean
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean " + beanName + " yaratıldıktan sonra işlem yapılıyor...");
        return bean;
    }

}
