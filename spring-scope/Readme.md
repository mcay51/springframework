# Spring Bean Scope'ları

Spring'de bean scope'ları, bir bean'in yaşam döngüsünü ve nasıl yönetileceğini belirler. Spring, aşağıdaki beş ana bean scope'unu sunar:

## Bean Scope Türleri

1. **Singleton** (Varsayılan):
    - Uygulama boyunca tek bir örneği oluşturulur.
    - Tüm isteklerde aynı örnek kullanılır.

2. **Prototype**:
    - Her istekte yeni bir örnek oluşturulur.
    - Yani her bean isteği için yeni bir nesne döner.

3. **Request**:
    - Web uygulamalarında geçerlidir.
    - Her HTTP isteği için yeni bir bean oluşturulur.

4. **Session**:
    - Web uygulamalarında geçerlidir.
    - Her HTTP oturumu için yeni bir bean oluşturulur.

5. **Global Session**:
    - Portlet tabanlı web uygulamalarında kullanılır.
    - Her global HTTP oturumu için yeni bir bean oluşturulur.

Bu bean scope'ları, uygulama ihtiyaçlarına göre bean yönetimini esnek hale getirir.
