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
public class FeatureConditionalClassController {
   private final String jacksonBean;
    public FeatureConditionalClassController(@Autowired(required = false) String jacksonBean) {
           this.jacksonBean = jacksonBean;
    }

    /**
     * @GetMapping: HTTP GET isteklerini karşılar.
     *
     * @return Bean değerleri.
     */

    @GetMapping("/conditional-on-class")
    @Operation(summary = "@ConditionalOnClass uygulamada belirli bir sınıf yüklü ise ilgili bean yüklenir", description = "@ConditionalOnClass uygulamada belirli bir sınıf yüklü ise ilgili bean yüklenir")
    public String getConditionalOnClass() {
        return "Jackson: " + jacksonBean;
    }

}
