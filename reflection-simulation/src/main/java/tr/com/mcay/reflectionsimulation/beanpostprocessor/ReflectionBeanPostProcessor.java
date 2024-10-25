package tr.com.mcay.reflectionsimulation.beanpostprocessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class ReflectionBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before Initialization: Bean Adı -> " + beanName);
        inspectBean(bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After Initialization: Bean Adı -> " + beanName);
        return bean;
    }

    private void inspectBean(Object bean) {
        Class<?> beanClass = bean.getClass();
        System.out.println("Bean Sınıfı: " + beanClass.getName());

        // Alanları incele
        Field[] fields = beanClass.getDeclaredFields();
        System.out.println("Alanlar:");
        for (Field field : fields) {
            System.out.println(" - " + field.getName() + " : " + field.getType().getName());
        }

        // Metodları incele
        Method[] methods = beanClass.getDeclaredMethods();
        System.out.println("Metodlar:");
        for (Method method : methods) {
            System.out.println(" - " + method.getName() + " : Dönüş Tipi -> " + method.getReturnType().getName());
        }
    }
}
