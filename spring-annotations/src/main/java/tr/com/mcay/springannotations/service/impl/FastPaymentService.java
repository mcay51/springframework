package tr.com.mcay.springannotations.service.impl;

import org.springframework.stereotype.Component;
import tr.com.mcay.springannotations.service.PaymentService;

@Component
public class FastPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Hızlı ödeme işlemi gerçekleştirildi.");

    }
}
