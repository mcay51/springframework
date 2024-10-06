package tr.com.mcay.springannotations.events;

/**
 * Kullanıcı oluşturma olayı.
 */
public class OrderUserCreatedEvent {

    private final String username;

    public OrderUserCreatedEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}