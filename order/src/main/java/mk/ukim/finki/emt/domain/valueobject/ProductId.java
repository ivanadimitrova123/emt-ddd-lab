package mk.ukim.finki.emt.domain.valueobject;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ProductId extends DomainObjectId {
    public ProductId() {
        super(DomainObjectId.randomId(ProductId.class).getId());
    }

    public ProductId(String id) {
        super(id);
    }
}
