package tr.com.mcay.reflectionsimulation.controller;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/person")
@Tag(name = "Person API", description = "Person API ile kullanıcı bilgilerine erişim sağlar.")
//@Scope("prototype")
public class PersonController {
    public PersonController(){

    }
    @GetMapping("/info")
    @Operation(summary = "Kullanıcı Bilgisi Getir", description = "Kullanıcının bilgilerini döndürür. Konsol çıktısını kontrol et. Reflection ile elde edilen beanlerin yüklenmesi sırasında elde edilen bilgileri gözlemleyebilirsin.")
    public String getPersonInfo() {
        return "Kullanıcı: Ali, Yaş: 25";
    }
}
