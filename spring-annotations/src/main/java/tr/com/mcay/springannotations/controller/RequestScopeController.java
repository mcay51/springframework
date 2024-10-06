package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.RequestScopeService;
@Tag(name = "BeanScopeController", description = "BeanScopeController API")
@RestController
@RequestMapping("/api")
@Scope("request")
public class RequestScopeController {
    private final RequestScopeService requestScopeService;
    private final RequestScopeService requestScopeService1;
    public RequestScopeController(RequestScopeService requestScopeService, RequestScopeService requestScopeService1) {
        this.requestScopeService = requestScopeService;
        this.requestScopeService1 = requestScopeService1;
    }
    /**
     * Request servislerinden mesaj döner.
     * @return Mesajlar.
     */
    @GetMapping("/scope-messages-request")
    @Operation(summary = "Request Scope", description = "RequestScopeService  Scope davranışlarını test eder.")
    public String getScopeRequestMessages() {
        return requestScopeService.getRequestScopeMessage() + "| " + requestScopeService1.getRequestScopeMessage();
    }


}
