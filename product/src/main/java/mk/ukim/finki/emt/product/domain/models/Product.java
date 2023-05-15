package mk.ukim.finki.emt.product.domain.models;

import mk.ukim.finki.emt.product.domain.valueObjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")

public class Product extends AbstractEntity<ProductId> {

    private String productName;

    private Quantity quantity;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Category> categoryList;
}
