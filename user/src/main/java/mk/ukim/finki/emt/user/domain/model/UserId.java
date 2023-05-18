package mk.ukim.finki.emt.user.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class UserId extends DomainObjectId {
    public UserId() {
        super(DomainObjectId.randomId(UserId.class).getId());
    }

    public UserId(String id) {
        super(id);
    }
}
