package tr.com.mcay.springinterceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    // Controller işlemine gitmeden önce çalışır
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre Handle method is called. URI: " + request.getRequestURI());
        return true; // false dönersek isteği sonlandırır ve devam etmez.
    }

    // Controller işledikten sonra ama view oluşturulmadan önce çalışır
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           org.springframework.web.servlet.ModelAndView modelAndView) throws Exception {
        System.out.println("Post Handle method is called.");
    }

    // Yanıt gönderildikten sonra çalışır
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Request and Response is completed.");
    }
}
