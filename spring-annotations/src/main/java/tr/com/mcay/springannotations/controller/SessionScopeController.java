package tr.com.mcay.springannotations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.mcay.springannotations.service.SessionScopeService;

@Tag(name = "BeanScopeController", description = "BeanScopeController API")
@RestController
@RequestMapping("/api")
@Scope("session")
public class SessionScopeController {
    private final SessionScopeService sessionScopeService;
    private final SessionScopeService sessionScopeService1;

    public SessionScopeController(SessionScopeService sessionScopeService, SessionScopeService sessionScopeService1) {
        this.sessionScopeService = sessionScopeService;
        this.sessionScopeService1 = sessionScopeService1;
    }

    /**
     * Session Scope servisinden mesaj döner.
     * @return Mesajlar.
     */
    @GetMapping("/scope-messages-session")
    @Operation(summary = "Session Scope", description = "SessionScopeService  Scope davranışlarını test eder.")
    public String getScopeRequestMessages() {
        return sessionScopeService.getSessionScopeMessage() + "| " + sessionScopeService1.getSessionScopeMessage();
    }

}
