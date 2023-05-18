package mk.ukim.finki.emt.user.services;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.user.domain.exeption.ClientNotFound;
import mk.ukim.finki.emt.user.domain.model.User;
import mk.ukim.finki.emt.user.domain.model.UserId;
import mk.ukim.finki.emt.user.domain.repository.UserRepository;
import mk.ukim.finki.emt.user.services.forms.UserForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User findById(@NonNull UserId id) {
        return userRepository.findById(id).orElseThrow(() -> new ClientNotFound(id.getId()));
    }

    @Override
    public UserId createUser(@NonNull UserForm user) {

        var u = new User(user.getName(), user.getLiving_address(), user.getEmail(), user.getPhone_number());
        return userRepository.saveAndFlush(u).getId();
    }

    @Override
    public User updateUser(@NonNull UserId userId, @NonNull UserForm user) {
        var u = findById(userId);

        u.updateUser(user.getName(), user.getLiving_address(), user.getEmail(), user.getPhone_number());

        return userRepository.saveAndFlush(u);
    }

    @Override
    public void deleteUser(@NonNull UserId userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}