package tr.com.mcay.springannotations.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tr.com.mcay.springannotations.service.OrderService;
@Service
@Profile("prod") // Bu servis sadece 'prod' profili aktif olduğunda çalışır
public class ProdOrderService implements OrderService {
    @Override
    public String placeOrder() {
        return "Sipariş, production ortamında başarıyla oluşturuldu!";
    }
}
