package tr.com.mcay.springannotations.order.service;

import org.springframework.cglib.core.Local;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tr.com.mcay.springannotations.order.dto.OrderDTO;
import tr.com.mcay.springannotations.order.mapper.OrderMapper;
import tr.com.mcay.springannotations.order.model.Order;
import tr.com.mcay.springannotations.order.repository.OrderRepository;
import tr.com.mcay.springannotations.product.dto.ProductDTO;
import tr.com.mcay.springannotations.product.mapper.ProductMapper;
import tr.com.mcay.springannotations.product.model.Product;
import tr.com.mcay.springannotations.product.repository.ProductRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    @Scheduled(fixedRate = 600000)//10 dakikada 1 kez çalışır
    public void performTaskIsa() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Zamanlanmış görev çalışıyor: " + startTime.format(formatter));
        OrderDTO orderDTO;
        for(int i=0;i<5;i++){
            orderDTO= placeOrder(getOrder());
            System.out.println(orderDTO.getCustomerName()+
                    " için Sipariş "+i+" Eklendi.");
        }
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("Zamanlanmış görev Başlangıç: " + startTime.format(formatter));
        System.out.println("Zamanlanmış görev tamamlandı : " + endTime.format(formatter));
    }

    private OrderDTO getOrder(){
        OrderDTO order = new OrderDTO();
        order.setCustomerName("Mustafa ÇAY");
        order.setProducts(getProducts());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        return  order;
    }
    private List<ProductDTO> getProducts(){
        ProductDTO product ;
        List<ProductDTO> products = new ArrayList<>();
        for(int i=0;i<10;i++){
            product= new ProductDTO();
            product.setName("Kazak-"+i);
            product.setPrice(2000d);
            product.setCreatedAt(LocalDateTime.now());
            product.setUpdatedAt(LocalDateTime.now());
            products.add(product);
        }
      return products;
    }
    /**
     * @param orderDTO
     * @return
     * @Transactional anotasyonu placeOrder metodu üzerinde tanımlı. Bu metot, hem siparişi kaydetmekte hem de ürünleri güncellemektedir.
     * Eğer ürünlerden birinin fiyatı sıfır veya negatifse, hata atılarak tüm işlem geri alınır (rollback yapılır).
     */
    @Transactional
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order order = OrderMapper.INSTANCE.orderDTOToOrder(orderDTO);
        List<Product> products =new ArrayList<>();
        for(ProductDTO productDTO : orderDTO.getProducts()){
            products.add(ProductMapper.INSTANCE.productDTOToProduct(productDTO)) ;
        }
        // Siparişi veritabanına kaydetme işlemi
        Order savedOrder = orderRepository.save(order);
        // Ürün stoğunu güncelleme işlemi
        for (Product product : products) {
            if (product.getPrice() <= 0) {
                throw new IllegalArgumentException("Ürün fiyatı sıfırdan büyük olmalıdır.");
            }
            productRepository.save(product);
        }

        return OrderMapper.INSTANCE.orderToOrderDTO(savedOrder);
    }

    /**
     * Okuma işlemleri için gereksiz yazma kilitlerini önlemek amacıyla işlemleri "read-only" olarak işaretleyebiliriz.
     * Bu, performansı iyileştirir ve bazı optimizasyonlara olanak sağlar.
     * @return
     */
    @Transactional(readOnly = true)
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(OrderMapper.INSTANCE::orderToOrderDTO)
                .collect(Collectors.toList());
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