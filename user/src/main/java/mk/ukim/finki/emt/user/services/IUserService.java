package mk.ukim.finki.emt.user.services;

import mk.ukim.finki.emt.user.domain.model.User;
import mk.ukim.finki.emt.user.domain.model.UserId;
import mk.ukim.finki.emt.user.services.forms.UserForm;

import java.util.List;

public interface  IUserService {
    User findById(UserId id);

    UserId createClient(UserForm client);

    User updateClient(UserId clientId, UserForm client);

    void deleteClient(UserId clientId);

    List<User> listAll();
}
