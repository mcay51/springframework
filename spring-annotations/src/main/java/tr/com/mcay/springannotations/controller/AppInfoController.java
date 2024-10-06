package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.AppInfoService;

@Tag(name = "AppInfoController", description = "AppInfoController API")
@RestController
@RequestMapping("/api")
public class AppInfoController {
    private final AppInfoService appInfoService;

    public AppInfoController(AppInfoService appInfoService) {
        this.appInfoService = appInfoService;
    }

    /**
     * Uygulama bilgilerini döner.
     * @return Uygulama adı ve versiyonu.
     */
    @GetMapping("/app-info")
    @Operation(summary = "Value anotasyonu ile properties dosyasından veri okuma", description = "Value anotasyonu ile properties dosyasından veri okuma")
    public String getAppInfo() {
        return appInfoService.getAppInfo();
    }
}
