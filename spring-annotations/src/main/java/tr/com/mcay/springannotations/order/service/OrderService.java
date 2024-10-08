package tr.com.mcay.springannotations.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.springannotations.order.dto.OrderDTO;
import tr.com.mcay.springannotations.order.mapper.OrderMapper;
import tr.com.mcay.springannotations.order.model.Order;
import tr.com.mcay.springannotations.order.repository.OrderRepository;
import tr.com.mcay.springannotations.product.dto.ProductDTO;
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
     * @param orderDTO
     * @return
     * @Transactional anotasyonu placeOrder metodu üzerinde tanımlı. Bu metot, hem siparişi kaydetmekte hem de ürünleri güncellemektedir.
     * Eğer ürünlerden birinin fiyatı sıfır veya negatifse, hata atılarak tüm işlem geri alınır (rollback yapılır).
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

    /**
     * İşlem Yayılımı (Propagation)
     * Propagation, bir işlemin (transaction) başka bir işlem çağırdığında nasıl davranacağını belirler. Spring, 7 farklı işlem yayılım türü sunar:
     * @param orderDTO
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void processOrder(OrderDTO orderDTO) {
        // Mevcut bir işlem (Transaction) varsa devam edilir, yoksa yeni bir işlem açılır.
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createOrder(OrderDTO invoiceDTO) {
        // Mevcut bir işlem (Transaction) varsa dondurulur ve yeni bir işlem başlatılır.
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void getOrderDetails(Long orderId) {
        // İşlem (Transaction) varsa işlem içinde, yoksa işlemsiz çalışır.
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void logProduct(ProductDTO auditDTO) {
        // Mevcut işlem (Transaction) varsa askıya alınır ve işlemsiz çalışılır.
    }
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateProduct(ProductDTO stockDTO) {
        // İşlem (Transaction) olmadan çağrılırsa Exception fırlatılır.
    }
    @Transactional(propagation = Propagation.NEVER)
    public void nonTransactionalOperation() {
        // İşlem (Transaction) olmadan çalışır, eğer işlem varsa hata fırlatır.
    }
    @Transactional(propagation = Propagation.NESTED)
    public void processSubOrder(OrderDTO subOrderDTO) {
        // Mevcut bir işlemin (Transaction) içinde yeni bir "nested" işlem açar. Eğer bu işlem başarısız olursa sadece bu alt işlem geri alınır.
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void lowIsolationOperation() {
        // Diğer işlemlerin henüz commit etmediği veriler okunabilir.
        //En düşük yalıtım seviyesi. Bir işlem henüz commit edilmeden başka işlemler tarafından görülebilir.
        // Bu seviyede dirty read mümkündür (başka bir işlemin henüz commit etmediği değişiklikleri okumak).
    }
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void safeReadOperation() {
        // Commit edilmiş veriler okunur.
        // Sadece commit edilmiş veriler okunabilir. Dirty read engellenir.
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void consistentReadOperation() {
        // Tekrarlanan okumalarda aynı sonuç alınır.
        // Aynı işlem boyunca aynı satır tekrar okunduğunda aynı veriler alınır.
        // Bu, non-repeatable read hatalarını engeller (aynı verinin tekrar okunduğunda farklı olması).
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void highIsolationOperation() {
        // Tüm işlemler sıralı ve tam yalıtımlıdır.
        // En yüksek yalıtım seviyesi. Tüm işlemler sıralı bir şekilde gerçekleştirilir,
        // bu da performans açısından pahalıdır ancak tüm veri tutarsızlıklarını engeller.
    }









}