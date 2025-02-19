# Spring Boot Annotation Projesi

## Proje Açıklaması
Bu proje, **Spring Boot** çerçevesinde kullanılan önemli anotasyonların kapsamlı bir şekilde ele alındığı ve çeşitli senaryolarla nasıl kullanılacağını gösteren bir uygulamadır. Projede, Spring Boot'un temel anotasyonlarından başlayarak, dependency injection, bean yönetimi, transaction yönetimi, cache yönetimi, asenkron işlemler ve Swagger entegrasyonu gibi konulara değinilmiştir.

## Kullanılan Teknolojiler
- **Spring Boot**
- **PostgreSQL**
- **MapStruct**
- **Swagger**
- **Spring AOP**
- **Java 11**

## Projede Ele Alınan Anotasyonlar

1. **@SpringBootApplication**  
   Spring Boot uygulamasının başlangıç noktasıdır. Bu anotasyon, üç temel anotasyonu (@Configuration, @EnableAutoConfiguration, ve @ComponentScan) bir araya getirir.

2. **@RestController**  
   Bir sınıfı Spring MVC Controller olarak tanımlar ve doğrudan HTTP yanıtları döndürmesini sağlar. Bu anotasyon ile birlikte @GetMapping, @PostMapping gibi yol eşleme anotasyonları kullanılır.

3. **@Service**  
   Bir sınıfın iş mantığını içeren bir Spring Service bileşeni olduğunu belirtir.

4. **@Autowired**  
   Spring'in dependency injection mekanizmasını kullanarak otomatik olarak bağımlılık enjekte edilmesini sağlar.

5. **@Scope**  
   Bean'lerin yaşam döngüsünü yönetmek için kullanılır. Bu projede singleton, prototype, request, session ve globalSession gibi scope türlerine değinilmiştir.

6. **@Value**  
   Dış kaynaklardan (örneğin, application.properties veya application.yml dosyalarından) konfigürasyon değerlerini alır. 
7. **@ConfigurationProperties(prefix = "app")** application.properties veya yml dosyasından konfigurasyonları typesafe bir şekilde alır.
7. **@Order**  
   Bean'lerin veya AOP Aspect'lerinin çalışma sıralarını belirlemek için kullanılır.

8. **@ConditionalOnProperty**, **@ConditionalOnMissingBean**, **@ConditionalOnClass**  ,**@Conditional**
   Belirli koşullara bağlı olarak bean tanımlamalarını etkinleştirmek veya devre dışı bırakmak için kullanılır.

9. **@Async**  
   Yöntemlerin asenkron olarak çalıştırılmasını sağlar.

10. **@EventListener**  
    Spring Event mekanizmasını kullanarak belirli olaylar gerçekleştiğinde çalışan dinleyicileri belirtir.

11. **@Scheduled**  
    Zamanlanmış görevleri tanımlar. Bu anotasyon, belirli aralıklarla veya zamanlamalara göre metodların çalıştırılmasını sağlar.

12. **@Retryable**  
    Bir işlemin hata verdiğinde belirli sayıda tekrar denemesi için kullanılır.

13. **@Cacheable**  
    Bir metodun döndürdüğü değeri önbelleğe alır ve sonraki çağrılarda önbellekten sonuç döner.

14. **@CircuitBreaker**  
    Hata oranı belli bir eşiği aştığında metodu devre kesici mantığıyla çalıştırarak sistemi koruma altına alır.

15. **@Transactional**  
    Veritabanı işlemlerinin atomik olarak gerçekleşmesini ve gerektiğinde rollback yapılmasını sağlar. Projede propagation ve isolation seviyelerine dair örnekler yer almaktadır.

16. **@SessionAttributes**  
    Bir controller sınıfı içerisindeki model verilerinin oturum boyunca saklanmasını sağlar.

17. **@PostConstruct** ve **@PreDestroy**  
    @PostConstruct, bean oluşturulduktan sonra çalıştırılan bir metodu tanımlar. @PreDestroy ise bean yok edilmeden önce çalıştırılan bir metodu tanımlar.

18. **@Profile**  
    Uygulamanın farklı ortamlarda (development, production vb.) çalışmasını sağlar. Projede, çeşitli profillerin nasıl tanımlanıp kullanılacağına dair örnekler sunulmuştur.

19. **@Component**, **@Configuration**, **@Repository**
    - **@Component:** Genel olarak Spring bileşenlerini tanımlar.
    - **@Configuration:** Spring konfigürasyon sınıflarını belirtir.
    - **@Repository:** Veritabanı işlemlerini gerçekleştiren sınıfları belirtir.

## Swagger Entegrasyonu
Projede **Swagger** entegrasyonu yapılmıştır. Swagger sayesinde uygulamanın REST API'lerini dokümante etmek ve test etmek mümkün hale gelmiştir. Swagger üzerinden API uç noktalarının çalışma detaylarını ve açıklamalarını görebilirsiniz.

### Swagger Kullanımı
Swagger'a erişim için:

http://localhost:8080/swagger-ui.html
Swagger üzerinde metodlar, **@Operation** anotasyonu ile açıklanmış ve profesyonel seviyede dökümantasyon eklenmiştir.

## MapStruct ile DTO Yapısı
Proje içerisinde **MapStruct** kullanılarak DTO yapıları oluşturulmuştur. Bu yapı sayesinde Entity'lerin DTO'ya ve DTO'ların Entity'ye dönüşümü hızlı ve efektif bir şekilde sağlanmıştır.

## Veritabanı Konfigürasyonu
Proje **PostgreSQL** veritabanı kullanılarak yapılandırılmıştır. Aşağıdaki ayarlar `application.properties` dosyasındadır.

# Kullanılan Anotasyonlar

## @SpringBootApplication
- `SpringAnnotationsApplication`

## @RestController
- `HelloController`
- `AppInfoController`
- `OrderController`
- `FeatureConditionalClassController`
- `FeatureConditionalController`
- `PersonController`
- `ResourceController`
- `AsyncController`
- `CachingController`
- `PaymentController`
- `OrderComponentController`
- `BeanScopeController`
- `AdvancedController`
- `EventController`
- `ConfigurationPropertiesController`

## @Service
- `AppInfoService`
- `HelloService`
- `RegularPaymentService`
- `DevOrderService`
- `ProdOrderService`
- `PersonServiceImpl`
- `EventListenerService`
- `EventPublisherService`
- `AsyncService`
- `CachingService`
- `CircuitBreakerService`
- `RetryService`
- `SessionScopeService`
- `RequestScopeService`
- `PrototypeService`
- `SingletonService`

## @Component
- `LazyResourceService`
- `FirstComponent`
- `SecondComponent`
- `LoggingAspect`
- `AnotherLogAspect`
- `CustomBeanPostProcessor`

## @Repository
- `PersonRepository`
- `ProductRepository`

## @Configuration
- `DataSourceConfig`
- `ClassConditionConfig`
- `MissingBeanConfig`
- `AppConfig`

## @Autowired
- `HelloController`
- `AppInfoController`
- `OrderController`
- `FeatureConditionalClassController`
- `FeatureConditionalController`
- `PersonController`
- `EventController`
- `ConfigurationPropertiesController`
- `EventPublisherService`
- `AsyncController`
- `CachingController`
- `BeanScopeController`
- `AdvancedController`

## @Value
- `AppInfoService`

## @Scheduled
- `ScheduledTaskService`
- `OrderService`

## @Transactional
- `OrderService`

## @Cacheable
- `CachingService`

## @Profile
- `DevOrderService`
- `ProdOrderService`

## @Conditional
- `DataSourceConfig`
- `ClassConditionConfig`
- `MissingBeanConfig`

## @Order
- `FirstComponent`
- `SecondComponent`
- `LoggingAspect`
- `AnotherLogAspect`

## @EventListener
- `EventListenerService`

## @Async
- `AsyncService`

## @Retryable
- `RetryService`

## @CircuitBreaker
- `CircuitBreakerService`

## @PostConstruct
- `FirstComponent`

## @PreDestroy
- `FirstComponent`

## @Scope
- `SessionScopeService`
- `RequestScopeService`
- `PrototypeService`
- `SingletonService`

## @Mapper
- `PersonMapper`

## @Operation
- `HelloController`
- `AppInfoController`
- `OrderController`
- `FeatureConditionalClassController`
- `FeatureConditionalController`
- `PersonController`
- `EventController`
- `ConfigurationPropertiesController`
- `CachingController`
- `AsyncController`
- `PaymentController`
- `BeanScopeController`
- `AdvancedController`
- `OrderComponentController`