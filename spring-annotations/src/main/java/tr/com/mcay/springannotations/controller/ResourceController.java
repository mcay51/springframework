package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.components.LazyResourceService;

/**
 * Bu örnekte ResourceController sınıfı LazyResourceService sınıfını çağırdığı için ilk bootstrap olurken Lazy Kaynak Başlatıldı console
 * mesajını görüntüleriz. Ancak Bu controller sınıfı olmaz ise LazyResourceService yüklenmeyecektir.
 */
@Tag(name = "ResourceController", description = "ResourceController API")
@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private final LazyResourceService lazyResourceService;
    @Autowired(required = false)
    public ResourceController(LazyResourceService lazyResourceService) {
        this.lazyResourceService = lazyResourceService;
    }

    @Operation(summary = "Kaynak işleme", description = "Lazy olarak başlatılan  kaynağı işleme.")
    @GetMapping("/process")
    public String processResource() {
        lazyResourceService.process();
        return "Lazy kaynak işleme tamamlandı.";
    }
}
