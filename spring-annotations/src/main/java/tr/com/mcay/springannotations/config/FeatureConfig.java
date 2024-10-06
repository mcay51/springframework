package tr.com.mcay.springannotations.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration: Konfigürasyon sınıfını belirtir.
 * @ConditionalOnProperty: Bu bean, 'feature.x.enabled' özelliği true olduğunda yaratılacak.
 */
@Configuration
public class FeatureConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.x.enabled", havingValue = "true", matchIfMissing = false)
    public String featureXBean() {
        return "Feature X is enabled!";
    }
}