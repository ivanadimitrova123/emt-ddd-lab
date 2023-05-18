package mk.ukim.finki.emt.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OrderItemId extends DomainObjectId {
    public OrderItemId() {
        super(DomainObjectId.randomId(OrderItemId.class).getId());
    }

    public OrderItemId(String id) {
        super(id);
    }
}
