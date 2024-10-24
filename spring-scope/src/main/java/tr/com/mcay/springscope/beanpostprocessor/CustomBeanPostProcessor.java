package tr.com.mcay.springscope.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before Initialization: " + beanName);
        return bean; // Bean'ı döndürün (üzerinde değişiklik yapmadığınız sürece)
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After Initialization: " + beanName);
        return bean; // Bean'ı döndürün (üzerinde değişiklik yapmadığınız sürece)
    }
}
