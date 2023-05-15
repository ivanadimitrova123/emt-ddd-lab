package mk.ukim.finki.emt.user.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_members")
public class User  extends AbstractEntity<UserId> {

    //one to many za order  ne treba?
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phone_number;
    private String living_address;
}
