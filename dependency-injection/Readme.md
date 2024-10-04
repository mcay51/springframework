# Bağımlılık Enjeksiyonu (Dependency Injection) Nedir?

Bağımlılık enjeksiyonu, nesneler arasındaki bağımlılıkların bu nesneler tarafından yönetilmek yerine dışarıdan sağlanmasını ifade eder. Bu yöntem, uygulamanın daha **esnek** ve **test edilebilir** olmasını sağlar.

## Bağımlılık Enjeksiyonu Türleri

### 1. **Constructor-Based Injection**
Bağımlılıkların oluşturucu (constructor) aracılığıyla enjeksiyonu yapılır. Bu yöntem, bağımlılıkların eksikliğini **compile time** sırasında kontrol etme avantajına sahiptir.

### 2. **Setter-Based Injection**
Bu yöntemde bağımlılıklar, setter metotları kullanılarak enjekte edilir. **İsteğe bağlı bağımlılıklar** için uygun bir yaklaşımdır.

### 3. **Field-Based Injection**
Bağımlılıklar doğrudan sınıf alanlarına enjekte edilir. Bu yöntem en kısa yöntemdir; ancak **daha az esneklik** sağlar ve test yazma aşamasında **zorluklar** çıkarabilir.
