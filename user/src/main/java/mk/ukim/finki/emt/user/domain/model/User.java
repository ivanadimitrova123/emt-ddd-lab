package mk.ukim.finki.emt.user.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.address.Address;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Table(name="user_members")
public class User  extends AbstractEntity<UserId> {

    private String name;
    private String email;
    private String phone_number;
    private Address living_address;

    public User() {
        super(DomainObjectId.randomId(UserId.class));
    }

    public User(String name, Address living_address, String email, String phone_number) {
        super(DomainObjectId.randomId(UserId.class));
        this.name = name;
        this.living_address = living_address;
        this.email = email;
        this.phone_number = phone_number;
    }

    public void updateUser(String name, Address living_address, String email, String phone_number) {
        this.name = name;
        this.living_address = living_address;
        this.email = email;
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User client = (User) o;
        return Objects.equals(name, client.name) && Objects.equals(living_address, client.living_address) && Objects.equals(email, client.email) && Objects.equals(phone_number, client.phone_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, living_address, email, phone_number);
    }
}
