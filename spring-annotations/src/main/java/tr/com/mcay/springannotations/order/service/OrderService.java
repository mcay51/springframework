package tr.com.mcay.springannotations.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.springannotations.order.dto.OrderDTO;
import tr.com.mcay.springannotations.order.mapper.OrderMapper;
import tr.com.mcay.springannotations.order.model.Order;
import tr.com.mcay.springannotations.order.repository.OrderRepository;
import tr.com.mcay.springannotations.product.model.Product;
import tr.com.mcay.springannotations.product.repository.ProductRepository;

/**
 * @Transactional, Spring'in işlem yönetimini (transaction management) sağlamasına olanak tanır.
 * Bu anotasyon sayesinde bir iş parçası bir bütün olarak ya başarılı olur ya da tamamen başarısız olur.
 * Veritabanı işlemleri sırasında, hatalar oluştuğunda işlemleri geri alarak (rollback), tutarlı bir veri durumu sağlar.
 * Ayrıca işlem yayılımı (propagation), yalıtım seviyeleri (isolation levels),
 * okuma/yazma optimizasyonları gibi işlemler üzerinde çeşitli kontrol mekanizmaları sunar.
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.orderMapper = orderMapper;
    }

    /**
     * @Transactional anotasyonu placeOrder metodu üzerinde tanımlı. Bu metot, hem siparişi kaydetmekte hem de ürünleri güncellemektedir.
     * Eğer ürünlerden birinin fiyatı sıfır veya negatifse, hata atılarak tüm işlem geri alınır (rollback yapılır).
     * @param orderDTO
     * @return
     */
    @Transactional
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order order = orderMapper.orderDTOToOrder(orderDTO);

        // Siparişi veritabanına kaydetme işlemi
        Order savedOrder = orderRepository.save(order);

        // Ürün stoğunu güncelleme işlemi
        for (Product product : order.getProducts()) {
            if (product.getPrice() <= 0) {
                throw new IllegalArgumentException("Ürün fiyatı sıfırdan büyük olmalıdır.");
            }
            productRepository.save(product);
        }

        return orderMapper.orderToOrderDTO(savedOrder);
    }
}