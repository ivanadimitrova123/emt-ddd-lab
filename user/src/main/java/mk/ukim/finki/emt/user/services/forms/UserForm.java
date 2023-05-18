package mk.ukim.finki.emt.user.services.forms;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.address.Address;

@Data
public class UserForm {
    @NotNull
    public String name;
    @NotNull
    public Address living_address;
    @NotNull
    public String email;
    @NotNull
    public String phone_number;
}
