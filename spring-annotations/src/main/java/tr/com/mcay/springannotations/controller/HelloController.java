package tr.com.mcay.springannotations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * @GetMapping("/hello"): Bu anotasyon, HTTP GET isteklerini bu metoda yönlendirir.
     * Bir selamlama mesajı olarak basit bir yanıt döndürür.
     */
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
