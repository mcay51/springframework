package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import tr.com.mcay.springannotations.config.AppConfig;
@Tag(name = "AppInfoController", description = "AppInfoController API")
@RestController
@RequestMapping("/api")
public class ConfigurationPropertiesController {

    private final AppConfig appConfig;

    @Autowired
    public ConfigurationPropertiesController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
    @Operation(summary = "ConfigurationProperties anotasyonu ile typesafe properties dosyasından veri okuma", description = "ConfigurationProperties anotasyonu ile typesafe properties dosyasından veri okuma")
    @GetMapping("/configuration-properties-app-info")
    public String getAppInfo() {
        return String.format("Name: %s, Version: %s",
                appConfig.getName(),
                appConfig.getVersion());
    }
}
