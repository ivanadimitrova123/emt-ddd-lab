package mk.ukim.finki.emt.product.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.product.domain.models.Product;
import mk.ukim.finki.emt.product.domain.repository.ProductRepository;
import mk.ukim.finki.emt.product.domain.valueObjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final ProductRepository productRepository;

    @PostConstruct
    public void init() {
        if (productRepository.count() == 0) {
            productRepository.saveAll(List.of(
                    new Product("Product 1", new Quantity(1), new Money(Currency.MKD, 100)),
                    new Product("Product 2", new Quantity(2), new Money(Currency.MKD, 200)),
                    new Product("Product 3", new Quantity(3), new Money(Currency.MKD, 300)),
                    new Product("Product 4", new Quantity(4), new Money(Currency.MKD, 400)),
                    new Product("Product 5", new Quantity(5), new Money(Currency.MKD, 500))
            ));
        }
    }
}
