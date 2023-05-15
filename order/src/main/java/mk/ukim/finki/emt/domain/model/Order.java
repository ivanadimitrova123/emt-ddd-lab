package mk.ukim.finki.emt.domain.model;

import mk.ukim.finki.emt.domain.valueobject.ClientId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;
    private Money total;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    //many to one
    @AttributeOverride(name = "id", column = @Column(name="client_id", nullable= false))
    private ClientId clientId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;


    public Order(){

    }
}
