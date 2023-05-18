package mk.ukim.finki.emt.domain.valueobject;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Product implements ValueObject {
    private final ProductId id;
    private final String name;
    private final String description;
    private final Money price;

    @JsonCreator
    public Product(String name, String description, Money price) {
        this.id = DomainObjectId.randomId(ProductId.class);
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
