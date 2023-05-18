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
    public UserId createClient(@NonNull UserForm client) {

        var c = new User(client.getName(), client.getLiving_address(), client.getEmail(), client.getPhone_number());
        return userRepository.saveAndFlush(c).getId();
    }

    @Override
    public User updateClient(@NonNull UserId clientId, @NonNull UserForm client) {
        var c = findById(clientId);

        c.updateClient(client.getName(), client.getLiving_address(), client.getEmail(), client.getPhone_number());

        return userRepository.saveAndFlush(c);
    }

    @Override
    public void deleteClient(@NonNull UserId clientId) {
        userRepository.deleteById(clientId);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}