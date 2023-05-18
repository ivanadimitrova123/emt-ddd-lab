package mk.ukim.finki.emt.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.domain.valueobject.User;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.domain.valueobject.Product;
import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private OrderType orderItem;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items;
   // @Embedded
   // @AttributeOverrides(
     //       @AttributeOverride(name = "id", column = @Column(name = "client_id", nullable = false)
       //     ))
    private User user;

    public Order() {
        super(DomainObjectId.randomId(OrderId.class));
        this.items = new HashSet<>();
    }

    public Order(Instant orderedOn, OrderState orderState, Currency currency, OrderType orderItem, User user) {
        super(DomainObjectId.randomId(OrderId.class));
        this.orderedOn = orderedOn;
        this.orderState = orderState;
        this.currency = currency;
        this.orderItem = orderItem;
        this.items = new HashSet<>();
        this.user = user;
    }

    public void changeState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void addItem(@NonNull Product product, int quantity) {
        items.add(new OrderItem(product.getPrice(), quantity, product.getId()));
    }

    public void removeItem(@NonNull OrderItemId id) {
        items.removeIf(i -> i.getId().equals(id));
    }

    public Money total() {
        return items.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(orderedOn, order.orderedOn) && orderState == order.orderState && currency == order.currency && orderItem == order.orderItem && Objects.equals(items, order.items) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderedOn, orderState, currency, orderItem, items, user);
    }
}
