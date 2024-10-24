# Spring Boot Interceptor

Spring Boot Interceptor, HTTP isteklerinin (request) ve yanıtlarının (response) işlenmesi sırasında devreye giren bir yapı taşır. Filtre mantığıyla çalışır ve genellikle bir controller'a ulaşmadan önce ya da controller'dan sonra belirli işlemleri yapmak için kullanılır.

## Interceptor'ların Kullanım Alanları

Spring Interceptor'lar, aşağıdaki görevlerde yaygın olarak kullanılır:

- **Giriş ve çıkış loglaması**: İsteklerin ve yanıtların loglanması.
- **Kimlik doğrulama ve yetkilendirme**: Kullanıcıların kimlik ve yetki kontrollerinin yapılması.
- **Genel çaplı veri manipülasyonları**: Örneğin, header eklemek veya loglar almak.
- **Performans ölçümü**: İstek ve yanıt sürelerinin ölçülmesi.
- **İstek/yanıt düzenlemeleri**: İstek veya yanıt üzerinde değişiklikler yapmak.

## Temel Metodlar

Interceptor'lar, `HandlerInterceptor` arayüzü ile uygulanır ve üç temel metodu vardır:

- **preHandle()**: İstek Controller'a gitmeden önce çalışır.
- **postHandle()**: Controller işlemi tamamlandıktan, fakat yanıt oluşturulmadan hemen önce çalışır.
- **afterCompletion()**: Yanıt client'a gönderildikten sonra çalışır.

Interceptor'lar, bu metodlar aracılığıyla HTTP iş akışına müdahale ederek işlemleri kontrol edebilir.
