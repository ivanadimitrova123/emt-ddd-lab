package mk.ukim.finki.emt.product.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ProductId extends DomainObjectId {
    public ProductId() {
        super(DomainObjectId.randomId(ProductId.class).getId());
    }

    public ProductId(String id) {
        super(id);
    }
}
