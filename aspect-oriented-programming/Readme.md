# Aspect-Oriented Programming (AOP) in Spring

Aspect-Oriented Programming (AOP), uygulamalarda farklı modüllere yayılmış çapraz kesen (cross-cutting) işlemleri tek bir yerde toplama imkanı sağlar. Çapraz kesen işlemler genellikle güvenlik, loglama, hata yönetimi gibi işlevlerdir. Spring Framework, AOP desteği ile bu tür işlemleri modüler ve esnek bir yapıya dönüştürür. Şimdi bunu projelendirip nasıl uygulayabileceğimizi inceleyelim.

## 1. AOP Nedir?

AOP, bir uygulamanın belirli davranışlarını, uygulamanın temel işlevinden ayırarak yöneten bir programlama paradigmasıdır. Spring AOP, Java uygulamaları üzerinde loglama, hata yakalama, güvenlik denetimi, performans takibi gibi işlemleri "aspect" denilen modüllerle gerçekleştirmeyi sağlar.

## 2. Örnek Senaryo: Loglama Aspect'i

Bu örnekte, tüm metodların çalışmadan önce ve sonra loglanmasını sağlayacağız. Bu, çapraz kesen bir işlem olduğu için AOP ile çözülmesi ideal bir yöntemdir.

### Proje Adımları:

Aspect, JoinPoint, Advice, Pointcut gibi AOP terminolojilerini kullanarak işlemleri gerçekleştireceğiz.

## 3. AOP Anotasyonları

- **`@Aspect`**: Bu anotasyon, bir sınıfı "aspect" olarak işaretler.
- **`@Before`**: Bir metodun çalışmasından önce bir işlem yapmak için kullanılır. Metod çağrılmadan önce loglama yapılmasını sağlar.
- **`@After`**: Bir metodun çalışmasından sonra bir işlem yapmak için kullanılır. Metod tamamlandıktan sonra loglama yapar.
- **`@Around`**: Hem metod çalışmadan önce hem de sonra işlem yapmak için kullanılır.
- **`@Pointcut`**: Hangi metodların hedefleneceğini belirtir. Belirli bir pattern'e uyan metodları hedefler. Bu örnekte, controller paketindeki tüm metodlar hedeflenmektedir.

