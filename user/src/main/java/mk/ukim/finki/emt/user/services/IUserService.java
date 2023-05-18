package mk.ukim.finki.emt.user.services;

import mk.ukim.finki.emt.user.domain.model.User;
import mk.ukim.finki.emt.user.domain.model.UserId;
import mk.ukim.finki.emt.user.services.forms.UserForm;

import java.util.List;

public interface  IUserService {
    User findById(UserId id);

    UserId createUser(UserForm user);

    User updateUser(UserId clientId, UserForm client);

    void deleteUser(UserId userId);

    List<User> listAll();
}
