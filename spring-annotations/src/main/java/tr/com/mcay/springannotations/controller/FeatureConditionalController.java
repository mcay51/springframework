package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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

    public FeatureConditionalController(@Autowired(required = false) String featureXBean) {
        this.featureXBean = featureXBean;
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

}
