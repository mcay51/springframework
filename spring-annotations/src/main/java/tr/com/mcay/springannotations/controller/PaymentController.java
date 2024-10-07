package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.PaymentService;
@Tag(name = "PaymentController", description = "PaymentController API")
@RestController
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "Ödeme işlemi", description = "Birincil ödeme servisini kullanarak ödeme işlemini gerçekleştirir.")
    @GetMapping("/process")
    public String processPayment() {
        paymentService.pay();
        return "Ödeme işlemi başarıyla tamamlandı.";
    }
}

