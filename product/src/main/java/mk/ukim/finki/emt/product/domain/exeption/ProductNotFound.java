package mk.ukim.finki.emt.product.domain.exeption;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message) {
        super(message);
    }
}
