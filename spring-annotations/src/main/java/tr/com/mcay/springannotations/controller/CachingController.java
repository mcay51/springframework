package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.CachingService;

@Tag(name = "AdvancedController", description = "AdvancedController API")
@RestController
@RequestMapping("/api")
public class CachingController {
    private final CachingService cachingService;
    public CachingController(CachingService cachingService) {
        this.cachingService = cachingService;
    }

    /**
     * @GetMapping: Cacheable işlem kontrolü.
     */
    @GetMapping("/cache")
    @Operation(summary = "Cache işlem kontrolü", description = "Bu endpoint ile cache'lenmiş bir veriyi alabilirsiniz.")
    public String getCachedData(@RequestParam String param) {
        return cachingService.getCachedData(param);
    }
}
