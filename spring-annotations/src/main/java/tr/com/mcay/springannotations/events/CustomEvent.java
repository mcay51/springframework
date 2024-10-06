package tr.com.mcay.springannotations.events;

/**
 * Basit bir olay (event) sınıfı.
 */
public class CustomEvent {

    private final String message;

    public CustomEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}