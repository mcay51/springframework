package tr.com.mcay.springannotations.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tr.com.mcay.springannotations.service.PaymentService;

/**
 * @Primary, Spring'in birden fazla aynı tipte bean olduğunda, hangi bean'in otomatik olarak seçileceğini belirtmek için kullanılır.
 * Eğer birden fazla bean tanımlıysa ve bir tercih yapılmadıysa, @Primary anotasyonu işaretlenmiş olan bean kullanılacaktır.
 * FastPaymentService ve ReqularPaymentService aynı sınıfın (PaymentService) implementasyonları
 */
@Primary
@Component
public class RegularPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Normal ödeme işlemi gerçekleştirildi.");
    }
}
