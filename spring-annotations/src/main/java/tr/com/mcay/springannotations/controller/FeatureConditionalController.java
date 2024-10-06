package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "ConditionalController", description = "ConditionalController API")
/**
 * @RestController: RESTful web servislerini sağlar.
 */
@RestController
@RequestMapping("/api")
public class FeatureConditionalController {
    private final String featureXBean;

    private final String defaultService;

   // private final String jacksonBean;
    public FeatureConditionalController(@Autowired(required = false) String featureXBean,
                                    @Autowired(required = false) String defaultService
                                        // , @Autowired(required = false) String jacksonBean
                                        ) {
        this.featureXBean = featureXBean;
        this.defaultService = defaultService;
        //this.jacksonBean = jacksonBean;
    }

    /**
     * @GetMapping: HTTP GET isteklerini karşılar.
     *
     * @return Bean değerleri.
     */
    @GetMapping("/conditional-on-property")
    @Operation(summary = "@ConditionalOnProperty Properties dosyasında feature.x.enabled=true ise FeatureConfig sınıfını yükler", description = "@ConditionalOnProperty Properties dosyasında feature.x.enabled=true ise FeatureConfig sınıfını yükler")
    public String getFeatures() {
        return "FeatureX: " + featureXBean;
    }

    @GetMapping("/conditional-on-missing")
    @Operation(summary = "@ConditionalOnMissing uygulamada myService adında bir bean yok ise defaultService bean i yüklemeyi sağlayan kontrol", description = "@ConditionalOnMissing uygulamada myService adında bir bean yok ise defaultService bean i yüklemeyi sağlayan kontrol")
    public String getConditionalOnMissing() {
        return "Default Service: " + defaultService;
    }

//    @GetMapping("/conditional-on-class")
//    @Operation(summary = "@ConditionalOnClass uygulamada belirli bir sınıf yüklü ise ilgili bean yüklenir", description = "@ConditionalOnClass uygulamada belirli bir sınıf yüklü ise ilgili bean yüklenir")
//    public String getConditionalOnClass() {
//        return "Jackson: " + jacksonBean;
//    }

}
