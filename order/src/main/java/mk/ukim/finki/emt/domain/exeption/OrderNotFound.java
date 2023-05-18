package mk.ukim.finki.emt.domain.exeption;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String message) {
        super(message);
    }
}
