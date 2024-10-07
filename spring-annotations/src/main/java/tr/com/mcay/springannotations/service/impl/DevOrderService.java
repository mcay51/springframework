package tr.com.mcay.springannotations.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tr.com.mcay.springannotations.service.OrderService;
@Service
@Profile("dev") // Bu servis sadece 'dev' profili aktif olduğunda çalışır
public class DevOrderService implements OrderService {
    @Override
    public String placeOrder() {
        return "Sipariş, developer ortamında başarıyla oluşturuldu!";
    }
}
