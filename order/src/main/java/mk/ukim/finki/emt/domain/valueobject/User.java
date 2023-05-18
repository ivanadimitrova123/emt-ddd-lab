package mk.ukim.finki.emt.domain.valueobject;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.address.Address;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class User implements ValueObject {
    private final String name;
    private final Address address;
    private final String email;
    private final String phone;

    @JsonCreator
    public User(String name, Address address, String email, String phone) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}
