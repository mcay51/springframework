package tr.com.mcay.springannotations.conditional;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    /**
     * @Conditional anotasyonu, belirli bir koşulun karşılanması durumunda bean tanımını etkinleştirir.
     * Bu anotasyonla, belirli bir koşul gerçekleştiğinde veya belirli bir sınıf/özellik mevcut olduğunda bir bean'in oluşturulmasını sağlayabilirsiniz.
     * Örneğin, farklı ortamlarda farklı yapılandırmaların çalışması için kullanılır.
     * @return
     */
    @Bean
    @Conditional(OnProductionCondition.class) // Custom koşul sınıfı
    public HikariDataSource productionDataSource() {
        return new HikariDataSource(); // Production ortamı için veritabanı bağlantısı
    }
}
