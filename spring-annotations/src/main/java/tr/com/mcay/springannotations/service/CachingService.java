package tr.com.mcay.springannotations.service;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Cacheable, bir metodun sonucunu önbelleğe alır ve aynı parametrelerle tekrar çağrıldığında önbellekteki sonucu döndürür.
 * Bu, tekrarlanan veritabanı veya dış API çağrılarını azaltmak için kullanılır.
 */
@Service
public class CachingService {
    /**
     * @Cacheable: Bu metodun sonucu 'items' adındaki cache'e kaydedilecek.
     */
    @Cacheable("items")
    public String getCachedData(String param) {
        System.out.println("Veritabanından veri alınıyor...");
        return "Veri: " + param;
    }
}
