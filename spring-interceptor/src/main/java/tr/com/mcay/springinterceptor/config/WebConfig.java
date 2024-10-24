package tr.com.mcay.springinterceptor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tr.com.mcay.springinterceptor.interceptor.RequestInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private RequestInterceptor requestInterceptor;

    public WebConfig(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor).addPathPatterns("/api/**"); // Sadece /api ile başlayan URL'lerde çalışır
    }
}
