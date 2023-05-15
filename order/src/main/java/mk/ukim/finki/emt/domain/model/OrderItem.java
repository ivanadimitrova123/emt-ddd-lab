package mk.ukim.finki.emt.domain.model;

import mk.ukim.finki.emt.domain.valueobject.ProductId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    //many to one
    @AttributeOverride(name="id", column = @Column(name="product_id", nullable = false))
    private ProductId productId;
}

