package mk.ukim.finki.emt.domain.valueobject;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserId extends DomainObjectId {
    public UserId() {
        super(DomainObjectId.randomId(UserId.class).getId());
    }

    public UserId(String id) {
        super(id);
    }
}