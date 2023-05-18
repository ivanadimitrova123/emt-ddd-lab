package mk.ukim.finki.emt.user.domain.exeption;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound(String message) {
        super(message);
    }
}
