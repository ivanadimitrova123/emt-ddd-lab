package mk.ukim.finki.emt.product.domain.models;

import mk.ukim.finki.emt.product.domain.valueObjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.util.Objects;
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

    protected Product() {
        super(DomainObjectId.randomId(ProductId.class));
    }

    public Product(String productName, Quantity quantity, Money price) {
        super(DomainObjectId.randomId(ProductId.class));
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void updateProduct(String productName, Quantity quantity, Money price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void addQuantity() {
        quantity = quantity.add();
    }

    public void subtractQuantity() {
        quantity = quantity.subtract();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) && Objects.equals(quantity, product.quantity) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productName, quantity, price);
    }



}
