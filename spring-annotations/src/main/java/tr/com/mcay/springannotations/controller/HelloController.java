package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.HelloService;


@Tag(name = "HelloController", description = "HelloController API")
/**
 * @RestController, RESTful web servisleri yazarken kullanılan bir annotation’dır.
 * @Controller ve @ResponseBody annotation’larını bir arada kullanır.
 * Yani, bu annotation ile yazılan metotlar varsayılan olarak JSON/XML döner.
 */
@RestController
/**
 * @RequestMapping: Bu anotasyon, bir HTTP isteğini belirli bir URL ile bu metoda eşler.
 * Hem GET, POST, PUT, DELETE gibi farklı HTTP metodlarını hem de path ayarlarını tanımlamak için kullanılır.
 */
@RequestMapping("/api")
public class HelloController {
    private final HelloService helloService;

    /**
     * @Autowired: Servis katmanını otomatik olarak inject eder.
     */
    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Operation(summary = "Servis katmanından merhaba mesajı alır", description = "HelloService'den gelen merhaba mesajını döner.")
    @GetMapping("/helloService")
    public String helloFromService() {
        return helloService.getHelloMessage();
    }

    @Operation(summary = "GetMapping ile Hello", description = "GetMapping kullanarak bir hello mesajı döner.")
    /**
     * @GetMapping("/hello"): Bu anotasyon, HTTP GET isteklerini bu metoda yönlendirir.
     * Bir selamlama mesajı olarak basit bir yanıt döndürür.
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }





}
